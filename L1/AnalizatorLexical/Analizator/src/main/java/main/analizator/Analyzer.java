package main.analizator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {

    private final Token codificare = new Token();
    private final SymbolTableBST tsIdentifier = new SymbolTableBST();
    private final SymbolTableBST tsConstant = new SymbolTableBST();
    private final List<String[]> FIP = new ArrayList<>();

    private final Pattern tokenPattern = Pattern.compile(
            "\"[^\"]*\"|" +
                    "[a-zA-Z_][a-zA-Z0-9_]*|" +
                    "[+-]?(0|[1-9][0-9]*)(\\.[0-9]{1,2})?(?![a-zA-Z_])|" +
                    "!=|<=|>=|==|" +
                    "[=+\\-*/%(){};,<>]");

    private final Pattern keywordPattern = Pattern.compile("^(atribuim|Intreg|Real|Structura|Citeste|Scrie|Daca|Altfel|CatTimp|Import|Start_Program|End_Program)$");
    private final Pattern operatorPattern = Pattern.compile("^(\\+|-|\\*|/|%|!=|<=|>=|<|>|=|egal|si|sau)$");
    private final Pattern separatorPattern = Pattern.compile("^([(),;{}])$");
    private final Pattern identifierPattern = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]*$");
    private final Pattern constantPattern = Pattern.compile("^(\"[^\"]*\"|[+-]?(0|[1-9][0-9]{0,8})(\\.[0-9]{1,2})?)$");

    private boolean inDeclaration = false;

    public void analyze(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                StringBuilder processedLine = new StringBuilder(line);
                Matcher matcher = tokenPattern.matcher(line);

                while (matcher.find()) {
                    String token = matcher.group();
                    int start = matcher.start();
                    int end = matcher.end();
                    for (int i = start; i < end; i++) processedLine.setCharAt(i, ' ');

                    if (token.isBlank()) continue;

                    if (token.equals(";")) {
                        inDeclaration = false;
                    }

                    if (keywordPattern.matcher(token).matches() || operatorPattern.matcher(token).matches() ||
                            separatorPattern.matcher(token).matches()) {
                        if (token.equals("Intreg") || token.equals("Real") || token.equals("Structura")) {
                            inDeclaration = true;
                        }
                        FIP.add(new String[]{codificare.getCode(token), "-1"});

                    } else if (identifierPattern.matcher(token).matches()) {
                        if (inDeclaration) {
                            int position = tsIdentifier.add(token);
                            FIP.add(new String[]{codificare.getCode("ID"), String.valueOf(position)});
                        } else {
                            int position = tsIdentifier.search(token);
                            if (position == -1) {
                                throw new Exception("Id " + token + " was not declared, line: " + lineNumber + ")");
                            }
                            FIP.add(new String[]{codificare.getCode("ID"), String.valueOf(position)});
                        }
                    } else if (constantPattern.matcher(token).matches()) {
                        int position = tsConstant.add(token);
                        FIP.add(new String[]{codificare.getCode("CONST"), String.valueOf(position)});
                    } else {
                        throw new Exception("Unrecognized token " + token + "line: " + lineNumber);

                    }
                }
                if (processedLine.toString().matches(".*\\S.*")) {
                    throw new Exception("Chars denied: " + lineNumber + ": " + processedLine);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveResults() {
        try (PrintWriter writer = new PrintWriter("FIP.txt")) {
            for (String[] pair : FIP) {
                writer.println(pair[0] + " " + pair[1]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        tsIdentifier.writeToFile("TS_ID.txt");
        tsConstant.writeToFile("TS_CONST.txt");
    }
}

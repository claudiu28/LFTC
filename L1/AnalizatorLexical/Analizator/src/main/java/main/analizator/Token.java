package main.analizator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Token {

    private static final Map<String, String> codes = new HashMap<>();

    public Token() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\claud\\OneDrive\\Desktop\\LFTC\\L1\\AnalizatorLexical\\Analizator\\src\\main\\resources\\codificare.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] pair= line.trim().split("\\s");
                if (pair.length != 2) continue;
                codes.put(pair[0], pair[1]);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getCode(String token) {
        String code = codes.get(token);
        if (code == null) {
            System.err.println("Unrecognised token: " + token);
            return null;
        }
        return code;
    }
}

package main.analizator;

public class Main {
    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer();
        analyzer.analyze(
                "C:\\Users\\claud\\OneDrive\\Desktop\\LFTC\\L1\\AnalizatorLexical\\Analizator\\src\\main\\resources\\source1.txt");
        analyzer.saveResults();
    }
}

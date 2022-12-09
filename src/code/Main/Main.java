package code.Main;

import code.Analyzer.Analysis;
import code.Problem.*;

public class Main {
    public static String GenGrid() {
        return (new GridGenerator()).toString();
    }
    public static void main(String[] args) throws Exception {
        Analysis.startAnalysis(args[0]);
    }
}

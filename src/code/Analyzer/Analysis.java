package code.Analyzer;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Analysis {
    public static CPUAnalyzer cpuAnalyzer;
    public static boolean isAnalysisEnabled = false;
    public static String grid = "7,5;100;3,4;2,6,3,5;0,0,4,0,1,8,1,4,77,1,5,1,3,2,94,4,3,46;";
    public static final int cpuCalcFreq = 10000;


    public static void startAnalysis(String strategy) throws Exception {
        isAnalysisEnabled = true;
        FileHandler fileHandler = new FileHandler("PerformanceLogs.log", true);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.addHandler(fileHandler);
        Analyzer analyzer = new Analyzer(strategy, grid, logger);
        cpuAnalyzer = new CPUAnalyzer(strategy, logger);
        analyzer.analyze();
        cpuAnalyzer.calcAvgCpuUtil();
    }
}

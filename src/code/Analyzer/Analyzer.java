package code.Analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.lang.management.ManagementFactory;

import code.Problem.CoastGuard;
import com.sun.management.OperatingSystemMXBean;


public class Analyzer {
    private final String strategy;
    private final String grid;
    private Logger logger;
    private String logMsg = "[%1$s_%2$s_%3$s]";

    public Analyzer(String strategy, String grid, Logger logger) throws IOException {
        this.strategy = strategy;
        this.grid = grid;
        this.logger = logger;
    }

    /**
     * @returns logs the used memory in KB.
     */
    public long getUsedMemory() {
        long freeMemory = Runtime.getRuntime().freeMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        return (totalMemory - freeMemory) / 1024;
    }

    public void analyze() throws Exception {
        long startTime = System.nanoTime(); // in nanoseconds
        String ans = CoastGuard.solve(this.grid, this.strategy, false);
        long executionTime = (System.nanoTime() - startTime) / 1_000_000; // in milliseconds
        int expandedNodes = Integer.parseInt(ans.split(";")[3]);

        logger.log(Level.INFO, String.format(logMsg, strategy, "Memory", getUsedMemory()));
        logger.log(Level.INFO, String.format(logMsg, strategy, "Time", executionTime));
        logger.log(Level.INFO, String.format(logMsg, strategy, "ExpandedNodes", expandedNodes));
    }



}


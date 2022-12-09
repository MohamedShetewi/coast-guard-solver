package code.Analyzer;

import com.sun.management.OperatingSystemMXBean;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CPUAnalyzer {
    private Double cpuUtil;
    private long count;
    private Logger logger;
    private String logMsg = "[%1$s_%2$s_%3$s]";
    private String strategy;

    public CPUAnalyzer(String strategy, Logger logger) throws IOException {
        cpuUtil = 0.0;
        this.logger = logger;
        this.strategy = strategy;
    }

    public void calcCurrentCpuUtil() {
        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        cpuUtil += operatingSystemMXBean.getProcessCpuLoad();
        count++;
    }

    public void calcAvgCpuUtil() {
        logger.log(Level.INFO, String.format(logMsg, strategy, "CPU", cpuUtil / (count * 1.0)));
    }
}

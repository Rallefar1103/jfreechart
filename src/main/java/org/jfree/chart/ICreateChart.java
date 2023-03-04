package org.jfree.chart;

import java.util.List;

@FunctionalInterface
public interface ICreateChart {
    JFreeChart createChart(String chartType, List<Object> parameters);
}

package org.jfree.chart;

import java.util.HashMap;
import java.util.Map;

public class ChartLookupTable {
    public static Map<String, String> chartLookupTable = new HashMap<String, String>() {
        {
            put("BarChart", "org.jfree.chart.charts.BarChart");
            put("PieChart", "org.jfree.chart.charts.PieChart");
            put("AreaChart", "org.jfree.chart.charts.AreaChart");
            put("BoxAndWhiskerChart", "org.jfree.chart.charts.BoxAndWhiskerChart");
            put("BubbleChart", "org.jfree.chart.charts.BubbleChart");
            put("CandleStickChart", "org.jfree.chart.charts.CandleStickChart");
            put("GantChart", "org.jfree.chart.charts.GantChart");
            put("HighLowChart", "org.jfree.chart.charts.HighLowChart");
            put("Histogram", "org.jfree.chart.charts.Histogram");
            put("LineChart", "org.jfree.chart.charts.LineChart");
            put("PolarChart", "org.jfree.chart.charts.PolarChart");
            put("RingChart", "org.jfree.chart.charts.RingChart");
            put("ScatterPlot", "org.jfree.chart.charts.ScatterPlot");
            put("TimeSeriesChart", "org.jfree.chart.charts.TimeSeriesChart");
            put("WaferMapChart", "org.jfree.chart.charts.WaferMapChart");
            put("WaterFallChart", "org.jfree.chart.charts.WaterFallChart");
            put("WindPlot", "org.jfree.chart.charts.WindPlot");
            put("XYAreaChart", "org.jfree.chart.charts.XYAreaChart");
            put("XYBarChart", "org.jfree.chart.charts.XYBarChart");
            put("XYLineChart", "org.jfree.chart.charts.XYLineChart");
            put("XYStepAreaChart", "org.jfree.chart.charts.XYStepAreaChart");
            put("XYStepChart", "org.jfree.chart.charts.XYStepChart");
        }
    };
}
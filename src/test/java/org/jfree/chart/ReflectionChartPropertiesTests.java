package org.jfree.chart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.charts.BarChart;
import org.jfree.chart.charts.PieChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.pie.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.junit.jupiter.api.Test;

public class ReflectionChartPropertiesTests {
    private Object chartObj;
    private Class<?> classObj;
    private JFreeChart barChart;
    private JFreeChart pieChart;
    private JFreeChart timeSeriesChart;
    private CategoryPlot catPlot;
    private PiePlot piePlot;
    private XYPlot xyPlot;
    private ChartFactoryReflection reflectionFactory;

    public List<Object> setUpBarChart() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(7445, "JFreeSVG", "Warm-up");
        dataset.addValue(24448, "Batik", "Warm-up");
        dataset.addValue(4297, "JFreeSVG", "Test");
        dataset.addValue(21022, "Batik", "Test");
        dataset.addValue(7445, "JFreeSVG", "Warm-up");
        dataset.addValue(24448, "Batik", "Warm-up");
        dataset.addValue(4297, "JFreeSVG", "Test");
        dataset.addValue(21022, "Batik", "Test");

        List<Object> parameters = new ArrayList<Object>();
        parameters.add("Performance: JFreeSVG vs Batik");
        parameters.add("Miliseconds");
        parameters.add("Miliseconds");
        parameters.add(dataset);

        this.classObj = Class.forName("org.jfree.chart.charts.BarChart");
        Constructor<?> chartConstructor = classObj.getConstructor();

        this.chartObj = chartConstructor.newInstance();
        this.barChart = ChartFactory.getChartRegular("BarChart", "Performance: JFreeSVG vs Batik", "Miliseconds",
                "Miliseconds",
                dataset);
        this.catPlot = (CategoryPlot) this.barChart.getPlot();

        return parameters;
    }

    public List<Object> setUpPieChart() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String title = "Smart Phones Manufactured / Q3 2011";
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Samsung", new Double(27.8));
        dataset.setValue("Others", new Double(55.3));
        dataset.setValue("Nokia", new Double(16.8));
        dataset.setValue("Apple", new Double(17.1));

        List<Object> parameters = new ArrayList<Object>();
        parameters.add(title);
        parameters.add(dataset);
        parameters.add(true);
        parameters.add(true);
        parameters.add(true);

        this.classObj = Class.forName("org.jfree.chart.charts.PieChart");
        Constructor<?> chartConstructor = classObj.getConstructor();

        this.chartObj = chartConstructor.newInstance();
        this.pieChart = ChartFactory.getChartRegular("PieChart", title, null, null, dataset);
        this.piePlot = (PiePlot) pieChart.getPlot();

        return parameters;
    }

    public List<Object> setUpTimeSeriesChart() throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException {
        String title = "Legal & General Unit Trust Prices";
        String timeAxisLabel = "Date";
        String valueAxisLabel = "Price per Unit";

        TimeSeries s1 = new TimeSeries("L&G European Index Trust");
        s1.add(new Month(2, 2001), 181.8);
        s1.add(new Month(3, 2001), 167.3);
        s1.add(new Month(4, 2001), 153.8);
        s1.add(new Month(5, 2001), 167.6);
        s1.add(new Month(6, 2001), 158.8);
        s1.add(new Month(7, 2001), 148.3);
        s1.add(new Month(8, 2001), 153.9);
        s1.add(new Month(9, 2001), 142.7);
        s1.add(new Month(10, 2001), 123.2);
        s1.add(new Month(11, 2001), 131.8);
        s1.add(new Month(12, 2001), 139.6);
        s1.add(new Month(1, 2002), 142.9);
        s1.add(new Month(2, 2002), 138.7);
        s1.add(new Month(3, 2002), 137.3);
        s1.add(new Month(4, 2002), 143.9);
        s1.add(new Month(5, 2002), 139.8);
        s1.add(new Month(6, 2002), 137.0);
        s1.add(new Month(7, 2002), 132.8);

        TimeSeries s2 = new TimeSeries("L&G UK Index Trust");
        s2.add(new Month(2, 2001), 129.6);
        s2.add(new Month(3, 2001), 123.2);
        s2.add(new Month(4, 2001), 117.2);
        s2.add(new Month(5, 2001), 124.1);
        s2.add(new Month(6, 2001), 122.6);
        s2.add(new Month(7, 2001), 119.2);
        s2.add(new Month(8, 2001), 116.5);
        s2.add(new Month(9, 2001), 112.7);
        s2.add(new Month(10, 2001), 101.5);
        s2.add(new Month(11, 2001), 106.1);
        s2.add(new Month(12, 2001), 110.3);
        s2.add(new Month(1, 2002), 111.7);
        s2.add(new Month(2, 2002), 111.0);
        s2.add(new Month(3, 2002), 109.6);
        s2.add(new Month(4, 2002), 113.2);
        s2.add(new Month(5, 2002), 111.6);
        s2.add(new Month(6, 2002), 108.8);
        s2.add(new Month(7, 2002), 101.6);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);

        List<Object> parameters = new ArrayList<Object>();
        parameters.add(title);
        parameters.add(timeAxisLabel);
        parameters.add(valueAxisLabel);
        parameters.add(dataset);

        this.classObj = Class.forName("org.jfree.chart.charts.TimeSeriesChart");
        Constructor<?> chartConstructor = classObj.getConstructor();

        this.chartObj = chartConstructor.newInstance();

        this.timeSeriesChart = ChartFactory.getChartRegular("TimeSeriesChart", title, timeAxisLabel, valueAxisLabel,
                dataset);
        return parameters;
    }

    @Test
    public void testThatChartPropertiesAreIdenticalForStaticAndDynamicCreatedBarChart()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = setUpBarChart();
        var expRenderer = (BarRenderer) this.catPlot.getRenderer();
        this.reflectionFactory = new ChartFactoryReflection();

        String classPath = ChartLookupTable.chartLookupTable.get("BarChart");
        var chart = this.reflectionFactory.getChartReflection(classPath, params);
        var plot = (CategoryPlot) chart.getPlot();
        var actualRenderer = (BarRenderer) plot.getRenderer();

        assertTrue(chart instanceof JFreeChart);
        assertTrue(chart instanceof BarChart);
        assertEquals(this.barChart, chart);
        assertEquals(this.catPlot, plot);
        assertEquals(expRenderer, actualRenderer);

    }

    @Test
    public void testThatChartPropertiesAreIdenticalForStaticAndDynamicCreatedPieChart()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = setUpPieChart();
        this.reflectionFactory = new ChartFactoryReflection();
        var expTitle = this.pieChart.getTitle();

        String classPath = ChartLookupTable.chartLookupTable.get("PieChart");
        var chart = this.reflectionFactory.getChartReflection(classPath, params);
        var plot = (PiePlot) chart.getPlot();
        var actualTitle = chart.getTitle();

        assertTrue(chart instanceof JFreeChart);
        assertTrue(chart instanceof PieChart);
        assertEquals(this.pieChart, chart);
        assertEquals(this.piePlot, plot);
        assertEquals(expTitle, actualTitle);

    }
}

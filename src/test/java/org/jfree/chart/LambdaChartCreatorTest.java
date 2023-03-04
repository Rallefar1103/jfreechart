package org.jfree.chart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.charts.BarChart;
import org.jfree.chart.charts.PieChart;
import org.jfree.chart.charts.TimeSeriesChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.junit.jupiter.api.Test;

public class LambdaChartCreatorTest {
    private JFreeChart barChart;
    private JFreeChart pieChart;
    private JFreeChart timeSeriesChart;
    private LambdaChartCreator lambdaCreator;

    public List<Object> setUpBarChart() {
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

        this.barChart = ChartFactory.getChartRegular("BarChart", "Performance: JFreeSVG vs Batik", "Miliseconds",
                "Miliseconds",
                dataset);
        return parameters;
    }

    public List<Object> setUpPieChart() {
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

        this.pieChart = ChartFactory.getChartRegular("PieChart", title, null, null, dataset);

        return parameters;
    }

    public List<Object> setUpTimeSeriesChart() {
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

        this.timeSeriesChart = ChartFactory.getChartRegular("TimeSeriesChart", title, timeAxisLabel, valueAxisLabel,
                dataset);
        return parameters;
    }

    @Test
    public void testLambdaCreationOfBarChartIsCorrect()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = setUpBarChart();
        this.lambdaCreator = new LambdaChartCreator();

        var chart = this.lambdaCreator.createChart("org.jfree.chart.charts.BarChart", params);

        assertTrue(chart instanceof JFreeChart);
        assertTrue(chart instanceof BarChart);
        assertEquals(this.barChart, chart);
    }

    @Test
    public void testlambdaForBarChartWillReturnNullOnInvalidStringInput()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = new ArrayList<>();
        this.lambdaCreator = new LambdaChartCreator();

        var result = this.lambdaCreator.createChart("org.jfree.chart.charts.Bar", params);
        assertEquals(null, result);

    }

    @Test
    public void testLambdaCreatorForBarChartWillReturnNullOnEmptyParameters()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = new ArrayList<>();
        this.lambdaCreator = new LambdaChartCreator();

        var result = this.lambdaCreator.createChart("org.jfree.chart.charts.BarChart", params);

        assertEquals(null, result);
    }

    @Test
    public void testLambdaCreationOfPieChartIsCorrect()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = setUpPieChart();
        this.lambdaCreator = new LambdaChartCreator();

        var chart = this.lambdaCreator.createChart("org.jfree.chart.charts.PieChart", params);

        assertTrue(chart instanceof JFreeChart);
        assertTrue(chart instanceof PieChart);
        assertEquals(this.pieChart, chart);
    }

    @Test
    public void testLambdaCreatorForPieChartWillReturnNullOnEmptyParameters()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = new ArrayList<>();
        this.lambdaCreator = new LambdaChartCreator();

        var result = this.lambdaCreator.createChart("org.jfree.chart.charts.PieChart", params);

        assertEquals(null, result);

    }

    @Test
    public void testlambdaForPieChartWillReturnNullOnInvalidStringInput()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = new ArrayList<>();
        this.lambdaCreator = new LambdaChartCreator();

        var result = this.lambdaCreator.createChart("org.jfree.chart.charts.Pie", params);

        assertEquals(null, result);
    }

    @Test
    public void testLambdaCreationOfTimeSeriesChartIsCorrect()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = setUpTimeSeriesChart();
        this.lambdaCreator = new LambdaChartCreator();

        var chart = this.lambdaCreator.createChart("org.jfree.chart.charts.TimeSeriesChart", params);

        assertTrue(chart instanceof JFreeChart);
        assertTrue(chart instanceof TimeSeriesChart);
        assertEquals(this.timeSeriesChart, chart);
    }

    @Test
    public void testLambdaCreatorForTimeSeriesChartWillReturnNullOnEmptyParameters()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = new ArrayList<>();
        this.lambdaCreator = new LambdaChartCreator();

        var result = this.lambdaCreator.createChart("org.jfree.chart.charts.TimeSeriesChart", params);

        assertEquals(null, result);

    }

    @Test
    public void testlambdaForTimeSeriesCharttWillReturnNullOnInvalidStringInput()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = new ArrayList<>();
        this.lambdaCreator = new LambdaChartCreator();

        var result = this.lambdaCreator.createChart("org.jfree.chart.charts.Time", params);

        assertEquals(null, result);
    }

    // Testing Generic NewChart Functional Interface Using Static Factory Chart
    // Creator

    @Test
    public void testDynamicLambdaCreatorForBarChart() {
        DefaultCategoryDataset chartData = new DefaultCategoryDataset();
        chartData.addValue(7445, "JFreeSVG", "Warm-up");
        chartData.addValue(24448, "Batik", "Warm-up");
        chartData.addValue(4297, "JFreeSVG", "Test");
        chartData.addValue(21022, "Batik", "Test");
        chartData.addValue(7445, "JFreeSVG", "Warm-up");
        chartData.addValue(24448, "Batik", "Warm-up");
        chartData.addValue(4297, "JFreeSVG", "Test");
        chartData.addValue(21022, "Batik", "Test");

        String chartTitle = "Performance: JFreeSVG vs Batik";
        String chartCategory = "Miliseconds";
        String chartValue = "Miliseconds";

        this.barChart = ChartFactory.getChartRegular("BarChart", chartTitle, chartCategory,
                chartValue,
                chartData);

        this.lambdaCreator = new LambdaChartCreator();
        NewChart<String, DefaultCategoryDataset, JFreeChart> function = (type, title, category, value,
                dataset) -> ChartFactory.getChartRegular(type, title, category, value, dataset);

        var result = this.lambdaCreator.createChart(function, "BarChart", chartTitle, chartCategory, chartValue,
                chartData);
        assertTrue(result instanceof JFreeChart);
        assertTrue(result instanceof BarChart);
        assertEquals(this.barChart, result);

    }

    @Test
    public void testDynamicLambdaCreatorForPieChart() {
        String chartTitle = "Smart Phones Manufactured / Q3 2011";
        DefaultPieDataset chartData = new DefaultPieDataset();
        chartData.setValue("Samsung", new Double(27.8));
        chartData.setValue("Others", new Double(55.3));
        chartData.setValue("Nokia", new Double(16.8));
        chartData.setValue("Apple", new Double(17.1));

        this.pieChart = ChartFactory.getChartRegular("PieChart", chartTitle, null, null, chartData);

        this.lambdaCreator = new LambdaChartCreator();
        NewChartAlt<String, DefaultPieDataset, JFreeChart> function = (type, title,
                dataset) -> ChartFactory.getChartRegular(type, title, null, null, dataset);

        var result = this.lambdaCreator.createChart(function, "PieChart", chartTitle, chartData);
        assertTrue(result instanceof JFreeChart);
        assertTrue(result instanceof PieChart);
        assertEquals(this.pieChart, result);

    }

    @Test
    public void testDynamicLambdaCreatorForTimeSeriesChart() {
        String chartTitle = "Legal & General Unit Trust Prices";
        String chartTimeAxisLabel = "Date";
        String chartValueAxisLabel = "Price per Unit";

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

        TimeSeriesCollection chartData = new TimeSeriesCollection();
        chartData.addSeries(s1);
        chartData.addSeries(s2);

        this.timeSeriesChart = ChartFactory.getChartRegular("TimeSeriesChart", chartTitle, chartTimeAxisLabel,
                chartValueAxisLabel,
                chartData);

        this.lambdaCreator = new LambdaChartCreator();
        NewChart<String, TimeSeriesCollection, JFreeChart> function = (type, title, category, value,
                dataset) -> ChartFactory.getChartRegular(type, title, category, value, dataset);

        var result = this.lambdaCreator.createChart(function, "TimeSeriesChart", chartTitle, chartTimeAxisLabel,
                chartValueAxisLabel, chartData);
        assertTrue(result instanceof JFreeChart);
        assertTrue(result instanceof TimeSeriesChart);
        assertEquals(this.timeSeriesChart, result);

    }
}

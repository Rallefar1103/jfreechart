package org.jfree.chart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.charts.BarChart;
import org.jfree.chart.charts.PieChart;
import org.jfree.chart.charts.TimeSeriesChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class ReflectionChartFactoryTest {
    private Object chartObj;
    private Class<?> classObj;
    private JFreeChart barChart;
    private JFreeChart pieChart;
    private JFreeChart timeSeriesChart;
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
    public void testDynamicLoadingOfBarChartIsCorrect()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = setUpBarChart();
        this.reflectionFactory = new ChartFactoryReflection();

        var chart = this.reflectionFactory.getChartReflection("org.jfree.chart.charts.BarChart", params);

        assertTrue(chart instanceof JFreeChart);
        assertTrue(chart instanceof BarChart);
        assertEquals(this.barChart, chart);
    }

    @Test
    public void testDynamicLoadingOfPieCharttIsCorrect()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = setUpPieChart();
        this.reflectionFactory = new ChartFactoryReflection();

        var chart = this.reflectionFactory.getChartReflection("org.jfree.chart.charts.PieChart", params);

        assertTrue(chart instanceof JFreeChart);
        assertTrue(chart instanceof PieChart);
        assertEquals(this.pieChart, chart);
    }

    @Test
    public void testDynamicLoadingOfTimeSeriesCharttIsCorrect()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = setUpTimeSeriesChart();
        this.reflectionFactory = new ChartFactoryReflection();
        var chart = this.reflectionFactory.getChartReflection("org.jfree.chart.charts.TimeSeriesChart", params);

        assertTrue(chart instanceof JFreeChart);
        assertTrue(chart instanceof TimeSeriesChart);
        assertEquals(this.timeSeriesChart, chart);
    }

    @Test
    public void testDynamicLoadingOfBarChartFailsWithInvalidStringInput()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = setUpBarChart();
        this.reflectionFactory = new ChartFactoryReflection();
        assertThrows(ClassNotFoundException.class, () -> {
            this.reflectionFactory.getChartReflection("org.jfree.chart.charts.Bar", params);
        });
    }

    @Test
    public void testDynamicLoadingOfBarChartFailsWithMissingParameters()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = new ArrayList<>();
        this.reflectionFactory = new ChartFactoryReflection();
        assertThrows(NoSuchMethodException.class, () -> {
            this.reflectionFactory.getChartReflection("org.jfree.chart.charts.BarChart", params);
        });
    }

    @Test
    public void testDynamicLoadingOfPieChartFailsWithInvalidStringInput()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = setUpPieChart();
        this.reflectionFactory = new ChartFactoryReflection();
        assertThrows(ClassNotFoundException.class, () -> {
            this.reflectionFactory.getChartReflection("org.jfree.chart.charts.Pie", params);
        });
    }

    @Test
    public void testDynamicLoadingOfPieChartFailsWithMissingParameters()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = new ArrayList<>();
        this.reflectionFactory = new ChartFactoryReflection();
        assertThrows(NoSuchMethodException.class, () -> {
            this.reflectionFactory.getChartReflection("org.jfree.chart.charts.PieChart", params);
        });
    }

    @Test
    public void testDynamicLoadingOfTimeSeriesChartFailsWithInvalidStringInput()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = setUpTimeSeriesChart();
        this.reflectionFactory = new ChartFactoryReflection();
        assertThrows(ClassNotFoundException.class, () -> {
            this.reflectionFactory.getChartReflection("org.jfree.chart.charts.Time", params);
        });
    }

    @Test
    public void testDynamicLoadingOfTimeSeriesChartFailsWithMissingParameters()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Object> params = new ArrayList<>();
        this.reflectionFactory = new ChartFactoryReflection();
        assertThrows(NoSuchMethodException.class, () -> {
            this.reflectionFactory.getChartReflection("org.jfree.chart.charts.TimeSeriesChart", params);
        });
    }

    // Testing Dynamic Retrieval of CreateChart Method Using ChartClassName as
    // Parameter
    @Test
    public void testGetChartMethodFromSignatureReturnsCorrectBarChartMethod()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.reflectionFactory = new ChartFactoryReflection();

        var method = this.reflectionFactory.getChartMethodFromMethodSignature("org.jfree.chart.charts.BarChart",
                "public BarChart createChart(String title, String categoryAxisLabel, String valueAxisLabel, DefaultCategoryDataset dataset)");
        Class<?> classType = method.getReturnType();

        assertTrue(method instanceof Method);
        assertEquals(BarChart.class, classType);
    }

    @Test
    public void testGetCorrectBarChartFromDynamicallyInvokedMethod()
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, ClassNotFoundException, InstantiationException {
        this.reflectionFactory = new ChartFactoryReflection();
        List<Object> params = setUpBarChart();
        Object[] inputParams = new Object[params.size()];

        for (int i = 0; i < params.size(); i++) {
            inputParams[i] = params.get(i);
        }

        var method = this.reflectionFactory.getChartMethodFromMethodSignature("org.jfree.chart.charts.BarChart",
                "public BarChart createChart(String title, String categoryAxisLabel, String valueAxisLabel, DefaultCategoryDataset dataset)");

        var result = method.invoke(this.chartObj, inputParams);
        assertEquals(this.barChart, result);
    }

    @Test
    public void testGetChartMethodFromSignatureReturnsCorrectAlternativeBarChartMethod()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.reflectionFactory = new ChartFactoryReflection();

        var method = this.reflectionFactory.getChartMethodFromMethodSignature("org.jfree.chart.charts.BarChart",
                "public BarChart createChart(String title, String categoryAxisLabel, String valueAxisLabel, DefaultCategoryDataset dataset, PlotOrientation orientation, Boolean legend, Boolean tooltips, Boolean urls)");
        Class<?> classType = method.getReturnType();

        assertTrue(method instanceof Method);
        assertEquals(BarChart.class, classType);
    }

    @Test
    public void testGetCorrectBarChartAlternativeFromDynamicallyInvokedMethod()
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, ClassNotFoundException, InstantiationException {
        this.reflectionFactory = new ChartFactoryReflection();
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
        parameters.add(PlotOrientation.VERTICAL);
        parameters.add(true);
        parameters.add(true);
        parameters.add(true);

        this.classObj = Class.forName("org.jfree.chart.charts.BarChart");
        Constructor<?> chartConstructor = this.classObj.getConstructor();

        this.chartObj = chartConstructor.newInstance();

        Object[] inputParams = new Object[parameters.size()];

        for (int i = 0; i < parameters.size(); i++) {
            inputParams[i] = parameters.get(i);
        }

        this.barChart = BarChart.createBarChart("Performance: JFreeSVG vs Batik", "Miliseconds", "Miliseconds", dataset,
                PlotOrientation.VERTICAL, true, true, true);

        var method = this.reflectionFactory.getChartMethodFromMethodSignature("org.jfree.chart.charts.BarChart",
                "public BarChart createChart(String title, String categoryAxisLabel, String valueAxisLabel, DefaultCategoryDataset dataset, PlotOrientation orientation, Boolean legend, Boolean tooltips, Boolean urls)");

        var result = method.invoke(this.chartObj, inputParams);
        assertEquals(this.barChart, result);
    }

    // Testing Dynamic Retrieval of CreateChart Method Using ChartClass as Parameter
    @Test
    public void testGetChartMethodFromSignatureAndClassReturnsCorrectBarChartMethod()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.reflectionFactory = new ChartFactoryReflection();
        this.classObj = Class.forName("org.jfree.chart.charts.BarChart");
        var method = this.reflectionFactory.getChartMethodFromMethodSignature(this.classObj,
                "public BarChart createChart(String title, String categoryAxisLabel, String valueAxisLabel, DefaultCategoryDataset dataset)");
        Class<?> classType = method.getReturnType();

        assertTrue(method instanceof Method);
        assertEquals(BarChart.class, classType);
    }

    @Test
    public void testGetCorrectBarChartFromDynamicallyInvokedMethodFromMethodSigAndClass()
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, ClassNotFoundException, InstantiationException {
        this.reflectionFactory = new ChartFactoryReflection();
        List<Object> params = setUpBarChart();
        Object[] inputParams = new Object[params.size()];

        for (int i = 0; i < params.size(); i++) {
            inputParams[i] = params.get(i);
        }

        var method = this.reflectionFactory.getChartMethodFromMethodSignature(this.classObj,
                "public BarChart createChart(String title, String categoryAxisLabel, String valueAxisLabel, DefaultCategoryDataset dataset)");

        var result = method.invoke(this.chartObj, inputParams);
        assertEquals(this.barChart, result);
    }

    @Test
    public void testGetCorrectBarChartAlternativeFromDynamicallyInvokedMethodSigAndClass()
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, ClassNotFoundException, InstantiationException {
        this.reflectionFactory = new ChartFactoryReflection();
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
        parameters.add(PlotOrientation.VERTICAL);
        parameters.add(true);
        parameters.add(true);
        parameters.add(true);

        this.classObj = Class.forName("org.jfree.chart.charts.BarChart");
        Constructor<?> chartConstructor = this.classObj.getConstructor();

        this.chartObj = chartConstructor.newInstance();

        Object[] inputParams = new Object[parameters.size()];

        for (int i = 0; i < parameters.size(); i++) {
            inputParams[i] = parameters.get(i);
        }

        this.barChart = BarChart.createBarChart("Performance: JFreeSVG vs Batik", "Miliseconds", "Miliseconds", dataset,
                PlotOrientation.VERTICAL, true, true, true);

        var method = this.reflectionFactory.getChartMethodFromMethodSignature(this.classObj,
                "public BarChart createChart(String title, String categoryAxisLabel, String valueAxisLabel, DefaultCategoryDataset dataset, PlotOrientation orientation, Boolean legend, Boolean tooltips, Boolean urls)");

        var result = method.invoke(this.chartObj, inputParams);
        assertEquals(this.barChart, result);
    }

}

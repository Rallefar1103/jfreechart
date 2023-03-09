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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.pie.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.junit.jupiter.api.Test;

public class ReflectionStrategyTest {
    private ChartFactoryReflection factory;

    @Test
    public void testingReflectionStrategySetTitle()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
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

        this.factory = new ChartFactoryReflection();
        BarChart chart = (BarChart) ChartFactory.getChartRegular("BarChart", "null", "Category", "Value", dataset);
        ReflectionStrategy strategy = new ReflectionStrategy(chart);
        List<Object> params = new ArrayList();

        String expectedTitle = "TitleTest";
        TextTitle testTitle = new TextTitle(expectedTitle);
        params.add(testTitle);

        strategy.setTitle("public void setTitleOnChart(TextTitle title)", params);

        String actualTitle = strategy.chart.getTitle().getText();

        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testingReflectionStrategySetTitleTwo()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
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

        this.factory = new ChartFactoryReflection();
        BarChart chart = (BarChart) ChartFactory.getChartRegular("BarChart", "null", "Category", "Value", dataset);
        ReflectionStrategy strategy = new ReflectionStrategy(chart);

        List<Object> params = new ArrayList();
        String expectedTitle = "TitleTest";
        String testTitle = expectedTitle;

        params.add(testTitle);
        strategy.setTitle("public void setTitleOnChart(String title)", params);

        String actualTitle = strategy.chart.getTitle().getText();

        assertEquals(expectedTitle, actualTitle);
    }
}

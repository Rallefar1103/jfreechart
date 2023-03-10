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

public class LambdaStrategyTest {
    private LambdaStrategy strategy;

    @Test
    public void testingLambdaStrategySetTitleUsingTextTitle()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(7445, "JFreeSVG", "Warm-up");
        dataset.addValue(24448, "Batik", "Warm-up");
        dataset.addValue(4297, "JFreeSVG", "Test");
        dataset.addValue(21022, "Batik", "Test");
        dataset.addValue(7445, "JFreeSVG", "Warm-up");
        dataset.addValue(24448, "Batik", "Warm-up");
        dataset.addValue(4297, "JFreeSVG", "Test");
        dataset.addValue(21022, "Batik", "Test");
        BarChart chart = (BarChart) ChartFactory.getChartRegular("BarChart", "null", "Category", "Value", dataset);
        String expectedTitle = "TitleTest";
        TextTitle testChartTitle = new TextTitle(expectedTitle);

        this.strategy = new LambdaStrategy<TextTitle>();

        ISetTitle<TextTitle> function = (title) -> chart.setTitle(title);

        this.strategy.setTitle(function, testChartTitle);

        String actualTitle = chart.getTitle().getText();

        assertEquals(expectedTitle, actualTitle);

    }

    @Test
    public void testingLambdaStrategySetTitleUsingString()
            throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(7445, "JFreeSVG", "Warm-up");
        dataset.addValue(24448, "Batik", "Warm-up");
        dataset.addValue(4297, "JFreeSVG", "Test");
        dataset.addValue(21022, "Batik", "Test");
        dataset.addValue(7445, "JFreeSVG", "Warm-up");
        dataset.addValue(24448, "Batik", "Warm-up");
        dataset.addValue(4297, "JFreeSVG", "Test");
        dataset.addValue(21022, "Batik", "Test");
        BarChart chart = (BarChart) ChartFactory.getChartRegular("BarChart", "null", "Category", "Value", dataset);
        String expectedTitle = "TitleTest";

        this.strategy = new LambdaStrategy<String>();

        ISetTitle<String> function = (title) -> chart.setTitle(title);

        this.strategy.setTitle(function, expectedTitle);

        String actualTitle = chart.getTitle().getText();

        assertEquals(expectedTitle, actualTitle);

    }
}

package org.jfree.chart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.Paint;
import java.awt.Color;
import org.jfree.chart.charts.BarChart;

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

        this.strategy = new LambdaStrategy<>();

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

        this.strategy = new LambdaStrategy<>();

        ISetTitle<String> function = (title) -> chart.setTitle(title);

        this.strategy.setTitle(function, expectedTitle);

        String actualTitle = chart.getTitle().getText();

        assertEquals(expectedTitle, actualTitle);

    }

    @Test
    public void testingLambdaStrategyDraw() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
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
        this.strategy = new LambdaStrategy<>();

        BufferedImage image = new BufferedImage(200, 100,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        Rectangle2D rect = new Rectangle2D.Double(0, 0, 200, 100);

        IDraw<Graphics2D, Rectangle2D> function = (graphics, rectangle) -> chart.draw(graphics, rectangle);

        this.strategy.draw(function, g2, rect);
    }

    @Test
    public void testingLambdaStrategySetBackground()
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

        BarChart chart = (BarChart) ChartFactory.getChartRegular("BarChart", "Title", "Category", "Value", dataset);
        this.strategy = new LambdaStrategy<>();

        Paint expectedBackground = Color.WHITE;

        ISetBackground<Paint> function = (paint) -> chart.setBackgroundPaint(paint);

        this.strategy.setBackgroundPaint(function, expectedBackground);

        Paint actualBackground = chart.getBackgroundPaint();

        assertEquals(expectedBackground, actualBackground);
    }
}

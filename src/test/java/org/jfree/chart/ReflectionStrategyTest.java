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

        BarChart chart = (BarChart) ChartFactory.getChartRegular("BarChart", "null", "Category", "Value", dataset);
        ReflectionStrategy strategy = new ReflectionStrategy(chart);
        List<Object> params = new ArrayList<Object>();

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

        BarChart chart = (BarChart) ChartFactory.getChartRegular("BarChart", "null", "Category", "Value", dataset);
        ReflectionStrategy strategy = new ReflectionStrategy(chart);

        List<Object> params = new ArrayList<Object>();
        String expectedTitle = "TitleTest";
        String testTitle = expectedTitle;

        params.add(testTitle);
        strategy.setTitle("public void setTitleOnChart(String title)", params);

        String actualTitle = strategy.chart.getTitle().getText();

        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testingReflectionStrategyDraw() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
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
        ReflectionStrategy strategy = new ReflectionStrategy(chart);

        BufferedImage image = new BufferedImage(200, 100,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        Rectangle2D rect = new Rectangle2D.Double(0, 0, 200, 100);

        List<Object> params = new ArrayList<Object>();
        params.add(g2);
        params.add(rect);
        params.add(null);
        params.add(null);

        strategy.draw(
                "public void drawChart(Graphics2D g2, Rectangle2D chartArea, Point2D anchor, ChartRenderingInfo info)",
                params);

    }

    //
    @Test
    public void testingReflectionStrategySetBackgroundPaint()
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

        BarChart chart = (BarChart) ChartFactory.getChartRegular("BarChart", "Title", "Category", "Value", dataset);
        ReflectionStrategy strategy = new ReflectionStrategy(chart);

        List<Object> params = new ArrayList<Object>();
        Paint expectedBackground = Color.WHITE;

        params.add(expectedBackground);
        strategy.setBackgroundPaint("public void setBackgroundPaintOnChart(Paint paint)", params);

        Paint actualBackground = strategy.chart.getBackgroundPaint();

        assertEquals(expectedBackground, actualBackground);
    }
}

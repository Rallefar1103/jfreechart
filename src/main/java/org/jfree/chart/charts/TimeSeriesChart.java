package org.jfree.chart.charts;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.IChart;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class TimeSeriesChart extends JFreeChart
        implements IChart {

    public TimeSeriesChart(String title, Font titleFont, Plot plot, boolean createLegend) {
        super(title, titleFont, plot, createLegend);
        // TODO Auto-generated constructor stub
    }

    public TimeSeriesChart() {
        super();
    }

    /**
     * Creates and returns a time series chart. A time series chart is an
     * {@link XYPlot} with a {@link DateAxis} for the x-axis and a
     * {@link NumberAxis} for the y-axis. The default renderer is an
     * {@link XYLineAndShapeRenderer}.
     * <P>
     * A convenient dataset to use with this chart is a
     * {@link org.jfree.data.time.TimeSeriesCollection}.
     *
     * @param title          the chart title ({@code null} permitted).
     * @param timeAxisLabel  a label for the time axis ({@code null}
     *                       permitted).
     * @param valueAxisLabel a label for the value axis ({@code null}
     *                       permitted).
     * @param dataset        the dataset for the chart ({@code null} permitted).
     *
     * @return A time series chart.
     */
    public static JFreeChart createTimeSeriesChart(String title,
            String timeAxisLabel, String valueAxisLabel, XYDataset dataset) {
        return createTimeSeriesChart(title, timeAxisLabel, valueAxisLabel,
                dataset, true, true, false);
    }

    /**
     * Creates and returns a time series chart. A time series chart is an
     * {@link XYPlot} with a {@link DateAxis} for the x-axis and a
     * {@link NumberAxis} for the y-axis. The default renderer is an
     * {@link XYLineAndShapeRenderer}.
     * <P>
     * A convenient dataset to use with this chart is a
     * {@link org.jfree.data.time.TimeSeriesCollection}.
     *
     * @param title          the chart title ({@code null} permitted).
     * @param timeAxisLabel  a label for the time axis ({@code null}
     *                       permitted).
     * @param valueAxisLabel a label for the value axis ({@code null}
     *                       permitted).
     * @param dataset        the dataset for the chart ({@code null} permitted).
     * @param legend         a flag specifying whether or not a legend is required.
     * @param tooltips       configure chart to generate tool tips?
     * @param urls           configure chart to generate URLs?
     *
     * @return A time series chart.
     */
    public static JFreeChart createTimeSeriesChart(String title,
            String timeAxisLabel, String valueAxisLabel, XYDataset dataset,
            boolean legend, boolean tooltips, boolean urls) {

        ValueAxis timeAxis = new DateAxis(timeAxisLabel);
        timeAxis.setLowerMargin(0.02); // reduce the default margins
        timeAxis.setUpperMargin(0.02);
        NumberAxis valueAxis = new NumberAxis(valueAxisLabel);
        valueAxis.setAutoRangeIncludesZero(false); // override default
        XYPlot plot = new XYPlot(dataset, timeAxis, valueAxis, null);

        XYToolTipGenerator toolTipGenerator = null;
        if (tooltips) {
            toolTipGenerator = StandardXYToolTipGenerator.getTimeSeriesInstance();
        }

        XYURLGenerator urlGenerator = null;
        if (urls) {
            urlGenerator = new StandardXYURLGenerator();
        }

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true,
                false);
        renderer.setDefaultToolTipGenerator(toolTipGenerator);
        renderer.setURLGenerator(urlGenerator);
        plot.setRenderer(renderer);

        return new TimeSeriesChart(title, JFreeChart.DEFAULT_TITLE_FONT,
                plot, legend);

    }

    @Override
    public JFreeChart createChart(String title, String categoryAxisLabel, String valueAxisLabel,
            DefaultCategoryDataset dataset) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JFreeChart createChart(String title, String timeAxisLabel, String valueAxisLabel,
            TimeSeriesCollection dataset) {
        return createTimeSeriesChart(title, timeAxisLabel, valueAxisLabel, dataset);
    }

    @Override
    public JFreeChart createChart(String title, DefaultPieDataset dataset, Boolean legend, Boolean tooltips,
            Boolean urls) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void drawChart(Graphics2D g2, Rectangle2D chartArea, Point2D anchor, ChartRenderingInfo info) {
        super.draw(g2, chartArea, anchor, info);
    }

    @Override
    public void setBackgroundPaintOnChart(Paint paint) {
        super.setBackgroundPaint(paint);
    }

    @Override
    public void setTitleOnChart(TextTitle title) {
        super.setTitle(title);
    }

    @Override
    public void setTitleOnChart(String title) {
        super.setTitle(title);
    }
}

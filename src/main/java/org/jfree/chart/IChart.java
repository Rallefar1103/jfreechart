package org.jfree.chart;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.awt.Paint;

import org.jfree.chart.title.Title;

public interface IChart {
    public void drawChart(Graphics2D g2, Rectangle2D chartArea, Point2D anchor,
            ChartRenderingInfo info);

    public void setSubtitlesOnChart(List<Title> subtitles);

    public void setBackgroundPaintOnChart(Paint paint);
}

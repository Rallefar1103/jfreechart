package org.jfree.chart;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Paint;
import java.util.List;

import org.jfree.chart.title.Title;

import java.awt.Graphics2D;

public interface IChartStrategy {
    void draw(Graphics2D g2, Rectangle2D chartarea, Point2D anchor, ChartRenderingInfo info);

    void setSubtitles(List<Title> subtitles);

    void setBackgroundPaint(Paint paint);
}

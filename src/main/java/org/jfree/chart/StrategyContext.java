package org.jfree.chart;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Paint;
import java.util.List;

import org.jfree.chart.title.Title;

import java.awt.Graphics2D;

public class StrategyContext {
    private IChartStrategy strategy;

    public StrategyContext() {

    }

    public void setStrategy(IChartStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeDraw(Graphics2D g2, Rectangle2D chartarea, Point2D anchor, ChartRenderingInfo info) {
        this.strategy.draw(g2, chartarea, anchor, info);
    }

    public void executeSetSubtitles(List<Title> subtitles) {
        this.strategy.setSubtitles(subtitles);
    }

    public void setBackgroundPaint(Paint paint) {
        this.strategy.setBackgroundPaint(paint);
    }
}

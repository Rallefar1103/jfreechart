package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.jfree.chart.title.Title;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Paint;

public interface IDynamicProxy {
        void draw(Graphics2D g2, Rectangle2D chartArea, Point2D anchor,
                        ChartRenderingInfo info)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException;

        void setSubtitles(List<Title> subtitles)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException;

        void setBackgroundPaint(Paint paint)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException;
}

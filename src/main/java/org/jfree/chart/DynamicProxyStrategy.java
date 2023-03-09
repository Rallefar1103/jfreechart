package org.jfree.chart;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import org.jfree.chart.title.Title;

import java.awt.Paint;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class DynamicProxyStrategy implements IDynamicProxy {

    private DynProxInvocHandler invocationHandler;

    public DynamicProxyStrategy(DynProxInvocHandler invocHandler) {
        this.invocationHandler = invocHandler;
    }

    @Override
    public void draw(Graphics2D g2, Rectangle2D chartArea, Point2D anchor,
            ChartRenderingInfo info)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        IChart proxyChart = (IChart) Proxy.newProxyInstance(JFreeChart.class.getClassLoader(),
                new Class[] { IChart.class }, this.invocationHandler);
        proxyChart.drawChart(g2, chartArea, anchor, info);
    }

    @Override
    public void setBackgroundPaint(Paint paint)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        IChart proxyChart = (IChart) Proxy.newProxyInstance(JFreeChart.class.getClassLoader(),
                new Class[] { IChart.class }, this.invocationHandler);
        proxyChart.setBackgroundPaintOnChart(paint);
    }

    @Override
    public void setSubtitles(List<Title> subtitles) throws ClassNotFoundException, NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        IChart proxyChart = (IChart) Proxy.newProxyInstance(JFreeChart.class.getClassLoader(),
                new Class[] { IChart.class }, this.invocationHandler);
        proxyChart.setSubtitlesOnChart(subtitles);
    }

}

package org.jfree.chart;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.List;

public class DynamicProxyChartCreator {
    private ChartInvocationHandler handler;

    public DynamicProxyChartCreator(ChartInvocationHandler handler) {
        this.handler = handler;
    }

    public JFreeChart getChartObject(String chartType, List<Object> params)
            throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException,
            InstantiationException {
        ChartFactoryReflection proxyFactory = (ChartFactoryReflection) Proxy.newProxyInstance(
                ChartFactoryReflection.class.getClassLoader(),
                new Class[] { ChartFactoryReflection.class }, this.handler);

        Class<?> classObj = Class.forName(chartType);
        Constructor<?> chartConstructor = classObj.getConstructor();

        Object chartObj = chartConstructor.newInstance();

        return proxyFactory.getChartObject(classObj, chartObj, params);

    }
}

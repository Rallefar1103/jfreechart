package org.jfree.chart;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DynamicProxyChartCreator {
    private ChartInvocationHandler handler;

    public DynamicProxyChartCreator(ChartInvocationHandler handler) {
        this.handler = handler;
    }

    public JFreeChart getChartObject(String chartType, List<Object> params)
            throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException,
            InstantiationException, MissingParamsException, InvalidChartNameException {
        Class<?> classObj;
        Constructor<?> chartConstructor;
        Object chartObj;

        IReflectionFactory proxyFactory = (IReflectionFactory) Proxy.newProxyInstance(
                ChartFactoryReflection.class.getClassLoader(),
                new Class[] { IReflectionFactory.class }, this.handler);

        if (!classNamePatternFound(chartType)) {
            classObj = null;
            chartObj = null;
        } else {
            classObj = Class.forName(chartType);
            chartConstructor = classObj.getConstructor();

            chartObj = chartConstructor.newInstance();

        }

        return proxyFactory.getChartObject(classObj, chartObj, params);

    }

    private Boolean classNamePatternFound(String className) {
        Pattern pattern = Pattern.compile("Chart");
        Matcher matcher = pattern.matcher(className);
        boolean result = matcher.find();
        return result;
    }
}

package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ReflectionStrategy implements IReflection {

    private ChartFactoryReflection factory;
    private String chartType;

    public ReflectionStrategy(String chartType) {
        this.factory = new ChartFactoryReflection();
        this.chartType = chartType;
    }

    @Override
    public void draw(String methodSigAsString, List<Object> params)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Class<?> classObj = Class.forName(this.chartType);
        Method draw = this.factory.getChartMethodFromMethodSignature(classObj, methodSigAsString);

        Object[] inputParams = new Object[params.size()];

        for (int i = 0; i < params.size(); i++) {
            inputParams[i] = params.get(i);
        }

        draw.invoke(classObj, inputParams);
    }

    @Override
    public void setSubtitles(String methodSigAsString, List<Object> params)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException,
            NoSuchMethodException, SecurityException {
        Class<?> classObj = Class.forName(this.chartType);
        Method setSub = this.factory.getChartMethodFromMethodSignature(classObj, methodSigAsString);

        Object[] inputParams = new Object[params.size()];

        for (int i = 0; i < params.size(); i++) {
            inputParams[i] = params.get(i);
        }

        setSub.invoke(classObj, inputParams);
    }

    @Override
    public void setBackgroundPaint(String methodSigAsString, List<Object> params)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, ClassNotFoundException {
        Class<?> classObj = Class.forName(this.chartType);
        Method setBackground = this.factory.getChartMethodFromMethodSignature(classObj, methodSigAsString);

        Object[] inputParams = new Object[params.size()];

        for (int i = 0; i < params.size(); i++) {
            inputParams[i] = params.get(i);
        }

        setBackground.invoke(classObj, inputParams);
    }

}

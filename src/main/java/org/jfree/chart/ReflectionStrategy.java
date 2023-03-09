package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.jfree.chart.title.TextTitle;

public class ReflectionStrategy implements IReflection {

    private ChartFactoryReflection factory;
    public JFreeChart chart;

    public ReflectionStrategy(JFreeChart chart) {
        this.factory = new ChartFactoryReflection();
        this.chart = chart;
    }

    @Override
    public void draw(String methodSigAsString, List<Object> params)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, InstantiationException {

        Method draw = this.factory.getChartMethodFromMethodSignature(this.chart.getClass(), methodSigAsString);

        Object[] inputParams = new Object[params.size()];

        for (int i = 0; i < params.size(); i++) {
            inputParams[i] = params.get(i);
        }

        draw.invoke(this.chart, inputParams);
    }

    @Override
    public void setTitle(String methodSigAsString, List<Object> params)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException,
            NoSuchMethodException, SecurityException, InstantiationException {

        Method setTitle = this.factory.getChartMethodFromMethodSignature(this.chart.getClass(), methodSigAsString);

        Object[] inputParams = new Object[1];

        inputParams[0] = params.get(0);

        setTitle.invoke(this.chart, inputParams);
    }

    @Override
    public void setBackgroundPaint(String methodSigAsString, List<Object> params)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, ClassNotFoundException {

        Method setBackground = this.factory.getChartMethodFromMethodSignature(this.chart.getClass(),
                methodSigAsString);

        Object[] inputParams = new Object[params.size()];

        for (int i = 0; i < params.size(); i++) {
            inputParams[i] = params.get(i);
        }

        setBackground.invoke(this.chart, inputParams);
    }

}

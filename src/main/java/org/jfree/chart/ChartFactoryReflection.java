package org.jfree.chart;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Paint;
import org.jfree.chart.charts.BarChart;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeSeriesCollection;

public class ChartFactoryReflection extends ChartFactory implements IReflectionFactory {

    private static final String METHOD_NAME = "methodName";
    private static final String METHOD_PARAM_NAMES = "methodParamNames";
    private static final String METHOD_PARAM_TYPES = "methodParamTypes";

    public ChartFactoryReflection() {

    }

    public JFreeChart getChartReflection(String chartType, List<Object> params)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> classObj = Class.forName(chartType);
        Constructor<?> chartConstructor = classObj.getConstructor();

        Object chartObj = chartConstructor.newInstance();

        return getChartObject(classObj, chartObj, params);

    }

    public JFreeChart getChartObject(Class<?> classObj, Object chartObj, List<Object> params)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        Method createMethod;
        Class<?>[] parameterTypes = new Class<?>[params.size()];

        for (int i = 0; i < parameterTypes.length; i++) {
            var objectType = params.get(i).getClass();
            parameterTypes[i] = objectType;
        }

        Object[] inputParams = new Object[params.size()];

        for (int i = 0; i < params.size(); i++) {
            inputParams[i] = params.get(i);
        }

        createMethod = classObj.getMethod("createChart", parameterTypes);
        return (JFreeChart) createMethod.invoke(chartObj, inputParams);

    }

    public Method getChartMethodFromMethodSignature(Class<?> chartClass, String methodAsString)
            throws NoSuchMethodException, SecurityException {
        var map = getMethodSigAndParams(methodAsString);
        if (map != null) {
            return chartClass.getMethod((String) map.get(METHOD_NAME), (Class<?>[]) map.get(METHOD_PARAM_TYPES));
        }
        return null;
    }

    public Method getChartMethodFromMethodSignature(String chartType, String methodAsString)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, ClassNotFoundException, InstantiationException {
        var map = getMethodSigAndParams(methodAsString);
        if (map != null) {
            Class<?> classObj = Class.forName(chartType);
            return classObj.getMethod((String) map.get(METHOD_NAME), (Class<?>[]) map.get(METHOD_PARAM_TYPES));
        }
        return null;
    }

    private Map<String, Object> getMethodSigAndParams(String methodAsString) {
        Pattern pattern = Pattern.compile("(\\w+)\\((.+)\\)");
        Matcher matcher = pattern.matcher(methodAsString);
        Map<String, Object> methodSigAsMap = new HashMap<>();
        if (matcher.find()) {
            methodSigAsMap.put(METHOD_NAME, matcher.group(1));
            String[] paramNames = matcher.group(2).split(",\\s*");
            methodSigAsMap.put(METHOD_PARAM_NAMES, paramNames);

            Class<?>[] parameterTypes = new Class<?>[paramNames.length];
            for (int i = 0; i < paramNames.length; i++) {
                parameterTypes[i] = getClassNameForType(paramNames[i]);
            }

            methodSigAsMap.put(METHOD_PARAM_TYPES, parameterTypes);
            return methodSigAsMap;
        }
        return null;
    }

    private Class<?> getClassNameForType(String type) {
        if (type.contains("Point2D")) {
            return Point2D.class;
        } else if (type.contains("Paint")) {
            return Paint.class;

        } else if (type.contains("String")) {
            return String.class;
        } else if (type.contains("Boolean") || type.contains("boolean")) {
            return Boolean.class;
        } else if (type.contains("DefaultCategoryDataset")) {
            return DefaultCategoryDataset.class;
        } else if (type.contains("DefaultPieDataset")) {
            return DefaultPieDataset.class;
        } else if (type.contains("TimeSeriesCollection")) {
            return TimeSeriesCollection.class;
        } else if (type.contains("PlotOrientation")) {
            return PlotOrientation.class;

        } else if (type.contains("TextTitle")) {
            return TextTitle.class;
        } else if (type.contains("Graphics2D")) {
            return Graphics2D.class;
        } else if (type.contains("Rectangle2D")) {
            return Rectangle2D.class;
        } else if (type.contains("int")) {
            return Integer.class;
        } else if (type.contains("ChartRenderingInfo")) {
            return ChartRenderingInfo.class;
        }

        else {
            return null;
        }

    }
}

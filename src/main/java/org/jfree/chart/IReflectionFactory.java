package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface IReflectionFactory {
        JFreeChart getChartReflection(String chartType, List<Object> params)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
                        IllegalAccessException, IllegalArgumentException, InvocationTargetException,
                        MissingParamsException, InvalidChartNameException;

        JFreeChart getChartObject(Class<?> classObj, Object chartObj, List<Object> params) throws NoSuchMethodException,
                        SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
                        MissingParamsException, InvalidChartNameException;

}

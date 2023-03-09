package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.jfree.chart.title.TextTitle;

public interface IReflection {

        void draw(String methodSigAsString, List<Object> params)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException, InstantiationException;

        void setTitle(String methodSigAsString, TextTitle title)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException, InstantiationException;

        void setBackgroundPaint(String methodSigAsString, List<Object> params)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException;

}

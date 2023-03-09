package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface IReflection {

        void draw(String methodSigAsString, List<Object> params)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException;

        void setSubtitles(String methodSigAsString, List<Object> params)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException;

        void setBackgroundPaint(String methodSigAsString, List<Object> params)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException;

}

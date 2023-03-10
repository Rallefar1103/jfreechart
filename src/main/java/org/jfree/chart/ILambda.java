package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ILambda<T> {
        void draw(String methodSigAsString, List<Object> params)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException, InstantiationException;

        void setTitle(ISetTitle<T> setTitle, T title)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException, InstantiationException;

        void setBackgroundPaint(String methodSigAsString, List<Object> params)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException;
}

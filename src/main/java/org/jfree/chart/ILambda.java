package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ILambda<T, R> {
        void draw(IDraw<T, R> draw, T g2, R rect)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException, InstantiationException;

        void setTitle(ISetTitle<T> setTitle, T title)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException, InstantiationException;

        void setBackgroundPaint(String methodSigAsString, List<Object> params)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException;
}

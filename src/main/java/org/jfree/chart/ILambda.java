package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ILambda<T, G, R, P> {
        void draw(IDraw<G, R> draw, G g2, R rect)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException, InstantiationException;

        void setTitle(ISetTitle<T> setTitle, T title)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException, InstantiationException;

        void setBackgroundPaint(ISetBackground<P> setBackground, P paint)
                        throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
                        IllegalArgumentException, InvocationTargetException;
}

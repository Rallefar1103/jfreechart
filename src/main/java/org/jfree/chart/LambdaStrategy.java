package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;

public class LambdaStrategy<T, G, R, P> implements ILambda<T, G, R, P> {

    @Override
    public void draw(IDraw<G, R> drawFunc, G g2, R rect)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, InstantiationException {
        drawFunc.draw(g2, rect);
    }

    @Override
    public void setTitle(ISetTitle<T> setTitleFunc, T title)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, InstantiationException {
        setTitleFunc.setTitle(title);
    }

    @Override
    public void setBackgroundPaint(ISetBackground<P> setBackgroundFunc, P paint)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        setBackgroundFunc.setBackground(paint);
    }

}

package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.jfree.chart.title.TextTitle;

public class LambdaStrategy<T, R> implements ILambda<T, R> {

    @Override
    public void setBackgroundPaint(String methodSigAsString, List<Object> params)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBackgroundPaint'");
    }

    @Override
    public void setTitle(ISetTitle<T> setTitleFunc, T title)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, InstantiationException {
        setTitleFunc.setTitle(title);
    }

    @Override
    public void draw(IDraw<T, R> drawFunc, T g2, R rect)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, InstantiationException {
        drawFunc.draw(g2, rect);
    }

}

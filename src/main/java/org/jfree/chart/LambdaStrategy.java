package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.jfree.chart.title.TextTitle;

public class LambdaStrategy<T> implements ILambda<T> {

    @Override
    public void draw(String methodSigAsString, List<Object> params)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, InstantiationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

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

}

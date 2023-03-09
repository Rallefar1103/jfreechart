package org.jfree.chart;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynProxInvocHandler implements InvocationHandler {

    private JFreeChart targetChart;

    public DynProxInvocHandler(JFreeChart chartTarget) {
        this.targetChart = chartTarget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.targetChart, args);

    }

}

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
        if (method.getName().equalsIgnoreCase("draw")) {
            //
        } else if (method.getName().equalsIgnoreCase("setSubtitles")) {
            //
        } else {
            //
        }

        Object returnResult = method.invoke(this.targetChart, args);
        return returnResult;

    }

}

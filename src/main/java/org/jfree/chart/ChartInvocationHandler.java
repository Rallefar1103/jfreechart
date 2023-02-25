package org.jfree.chart;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class ChartInvocationHandler implements InvocationHandler {
    // target
    private ChartFactoryReflection chartFactoryTarget;

    public ChartInvocationHandler(ChartFactoryReflection factoryTarget) {
        this.chartFactoryTarget = factoryTarget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equalsIgnoreCase("getChartObject")) {

            List<Object> params = (List<Object>) args[2];

            if (params.isEmpty()) {
                throw new RuntimeException("You cannot pass empty parameters");
            }

            Object returnResult = method.invoke(this.chartFactoryTarget, args);
            return returnResult;
        }

        return null;
    }

}

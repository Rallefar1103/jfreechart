package org.jfree.chart;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

public class ChartInvocationHandler implements InvocationHandler {
    // target
    private ChartFactoryReflection chartFactoryTarget;

    public ChartInvocationHandler(ChartFactoryReflection factoryTarget) {
        this.chartFactoryTarget = factoryTarget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable, UndeclaredThrowableException {
        if (method.getName().equalsIgnoreCase("getChartObject")) {
            Class<?> classObj = (Class<?>) args[0];

            List<Object> params = (List<Object>) args[2];

            if (classObj == null) {
                throw new InvalidChartNameException("You did not provide a valid Chart class name");
            }

            if (params.isEmpty()) {
                throw new MissingParamsException("You cannot pass empty parameters");
            }

            Object returnResult = method.invoke(this.chartFactoryTarget, args);
            return returnResult;
        }

        return null;
    }

}

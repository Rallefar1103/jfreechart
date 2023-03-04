package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class LambdaChartCreator {
    private IReflectionFactory reflectionFactory;

    public LambdaChartCreator() {
        reflectionFactory = new ChartFactoryReflection();
    }

    JFreeChart createChart(String chartType, List<Object> parameters)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ICreateChart obj = (type, params) -> {
            try {
                return reflectionFactory.getChartReflection(chartType, parameters);
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                    | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                    | MissingParamsException | InvalidChartNameException e) {
                return null;
            }

        };
        return obj.createChart(chartType, parameters);
    }

}

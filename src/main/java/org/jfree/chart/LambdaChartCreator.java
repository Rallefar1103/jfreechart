package org.jfree.chart;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class LambdaChartCreator {
    private IReflectionFactory reflectionFactory;

    public LambdaChartCreator() {
        reflectionFactory = new ChartFactoryReflection();
    }

    public JFreeChart createChart(String chartType, List<Object> parameters)
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

    public <T, D, R> R createChart(NewChart<T, D, R> func, T type, T title, T category, T value, D dataset) {
        return func.create(type, title, category, value, dataset);
    }

    public <T, D, R> R createChart(NewChartAlt<T, D, R> func, T type, T title, D dataset) {
        return func.create(type, title, dataset);
    }

}

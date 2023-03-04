package org.jfree.chart;

public interface NewChartAlt<T, DefaultCategoryDataset, R> {
    R create(T type, T title, DefaultCategoryDataset dataset);
}

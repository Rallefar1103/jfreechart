package org.jfree.chart;

public interface NewChart<T, D, R> {
    R create(T type, T title, T category, T value, D dataset);

}

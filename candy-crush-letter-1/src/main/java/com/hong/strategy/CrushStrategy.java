package com.hong.strategy;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author hongrunhao
 * @description A common interface for execution methods
 * @date 2024/02/20 020
 */
@FunctionalInterface
public interface CrushStrategy {

    default <T, U> void printResult(T t, Consumer<T> consumer) {
        consumer.accept((T) t);
    }

    default <T, U> void printResult(T t, U u, BiConsumer<T, U> consumer) {
        consumer.accept((T) t, (U) u);
    }

    String execute(String input);

}

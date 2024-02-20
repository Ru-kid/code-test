package com.hong.strategy;

import java.util.function.Consumer;

/**
 * @author hongrunhao
 * @description 通用的执行方法接口
 * @date 2024/02/20 020
 */
@FunctionalInterface
public interface CrushStrategy {

    void execute(String input);

    default <T> void action(T t, Consumer<T> action) {
        action.accept((T) t);
    }

}

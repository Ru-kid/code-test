package com.hong.strategy.impl;

import com.hong.constant.GlobalConstant;
import com.hong.strategy.CrushStrategy;
import com.hong.utils.CommonUtils;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hongrunhao
 * @description replace the same character that appears more than three times in a row
 * <p>
 * Instead of removing the consecutively identical characters, replace them with a
 * single character that comes before it alphabetically.
 * Example:
 * ccc -> b
 * bbb -> a
 * Input: abcccbad
 * Output:
 * -> abbbad, ccc is replaced by b
 * -> aaad, bbb is replaced by a
 * -> d
 * @date 2024/02/20 020
 */
public class CrushByReplace implements CrushStrategy {

    @Override
    public String execute(String input) {
        if (input.length() < GlobalConstant.CHAR_REP_NUM) {
            printResult(input, (p) -> System.out.println("-> " + p));
            return input;
        }

        StringBuilder output = new StringBuilder(input);

        AtomicReference<String> subStr = new AtomicReference<>();
        AtomicReference<String> repStr = new AtomicReference<>();
        Map<Integer, Integer> removeIndexMap = CommonUtils.recordRemoveIndex(input);
        removeIndexMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByKey().reversed())
                .forEach(entry -> {
                    char c = input.charAt(entry.getKey());
                    subStr.set(input.substring(entry.getKey(), entry.getValue()));
                    repStr.set(Character.toUpperCase(c) == GlobalConstant.ASCII_A ? "" : String.valueOf((char) (c - 1)));
                    output.replace(entry.getKey(), entry.getValue(), String.valueOf(repStr));
                });

        printResult(output, new String[]{String.valueOf(subStr), String.valueOf(repStr)}, (p1, p2) -> System.out.println("-> " + p1 + ", " + p2[0] + " is replaced by " + p2[1]));
        if (output.length() >= GlobalConstant.CHAR_REP_NUM && !input.equals(output.toString())) {
            return execute(output.toString());
        }

        return output.toString();
    }

}

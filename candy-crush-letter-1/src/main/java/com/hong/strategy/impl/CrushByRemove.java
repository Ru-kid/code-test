package com.hong.strategy.impl;

import com.hong.constant.GlobalConstant;
import com.hong.strategy.CrushStrategy;
import com.hong.utils.CommonUtils;

import java.util.Map;

/**
 * @author hongrunhao
 * @description removes the same character that appears more than three times in a row
 * <p>
 * For a given string that only contains alphabet characters a-z, if 3 or more consecutive
 * characters are identical, remove them from the string. Repeat this process until
 * there is no more than 3 identical characters sitting besides each other.
 * Example:
 * Input: aabcccbbad
 * Output:
 * -> aabbbad
 * -> aaad
 * -> d
 * @date 2024/02/20 020
 */
public class CrushByRemove implements CrushStrategy {

    @Override
    public String execute(String input) {
        if (input.length() < GlobalConstant.CHAR_REP_NUM) {
            printResult(input, (p) -> System.out.println("-> " + p));
            return input;
        }

        StringBuilder output = new StringBuilder(input);

        Map<Integer, Integer> removeIndexMap = CommonUtils.recordRemoveIndex(input);
        removeIndexMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByKey().reversed())
                .forEach(entry -> output.replace(entry.getKey(), entry.getValue(), ""));

        if (input.equals(output.toString())) {
            printResult(output, (p) -> System.out.println("-> " + p));
            return output.toString();
        }
        printResult(output, (p) -> System.out.println("-> " + p));
        if (output.length() >= GlobalConstant.CHAR_REP_NUM && !input.equals(output.toString())) {
            return execute(output.toString());
        }

        return output.toString();
    }

}

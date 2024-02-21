package com.hong.utils;

import com.hong.constant.GlobalConstant;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author hongrunhao
 * @description general utility class
 * @date 2024/02/20 019
 */
public class CommonUtils {

    /**
     * determines whether all characters of a string are the same letters
     *
     * @param str
     * @return
     */
    public static boolean isAllCharSame(String str) {
        String upperStr = str.toUpperCase();
        char firstChar = upperStr.charAt(0);
        return upperStr.chars().allMatch(c -> c == firstChar);
    }

    /**
     * record the starting subscript of the string that needs to be deleted
     *
     * @param input
     * @return
     */
    public static Map<Integer, Integer> recordRemoveIndex(String input) {
        int count = 1;
        Map<Integer, Integer> removeIndexMap = new TreeMap<>();

        if (CommonUtils.isAllCharSame(input)) {
            removeIndexMap.put(0, input.length());
            return removeIndexMap;
        }

        for (int i = 1, strLength = input.length(); i < strLength; i++) {
            if (input.charAt(i - 1) == input.charAt(i)) {
                count++;
            } else {
                if (count >= GlobalConstant.CHAR_REP_NUM) {
                    removeIndexMap.put(i - count, i);
                }
                count = 1;
            }
            if (count >= GlobalConstant.CHAR_REP_NUM) {
                removeIndexMap.put(i + 1 - count, i + 1);
            }
        }
        return removeIndexMap;
    }

}

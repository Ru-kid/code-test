package com.hong.handle;

import com.hong.utils.CommonUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author hongrunhao
 * @description
 * @date 2024/02/20 019
 */
public class CandyCrushLetterHandle {

    //连续相同字符的重复数
    private static final int CHAR_REP_NUM = 3;
    //ASCII A
    private static final char ASCII_A = 65;

    /**
     * 移除连续出现三次以上的相同字符
     *
     * @param input
     */
    public static void remove(String input) {
        StringBuilder output = new StringBuilder(input);

        Map<Integer, Integer> removeIndexMap = recordRemoveIndex(input);
        Iterator it = ((TreeMap<Integer, Integer>) removeIndexMap).descendingMap().entrySet().iterator();
        Map.Entry<Integer, Integer> entry = null;

        while (it.hasNext()) {
            entry = (Map.Entry<Integer, Integer>) it.next();
            //output.delete(entry.getKey(), entry.getValue());
            output.replace(entry.getKey(), entry.getValue(), "");
        }

        if (!input.equals(output.toString())) {
            System.out.println("-> " + output);
            if (output.length() >= CHAR_REP_NUM) {
                remove(output.toString());
            }
        }
    }

    /**
     * 替换连续出现三次以上的相同字符
     *
     * @param input
     */
    public static void replace(String input) {
        StringBuilder output = new StringBuilder(input);

        Map<Integer, Integer> removeIndexMap = recordRemoveIndex(input);
        Iterator it = ((TreeMap<Integer, Integer>) removeIndexMap).descendingMap().entrySet().iterator();
        Map.Entry<Integer, Integer> entry = null;

        String subStr = null;
        String repStr = null;

        while (it.hasNext()) {
            entry = (Map.Entry<Integer, Integer>) it.next();
            //被替代字符
            char c = input.charAt(entry.getKey());
            //被替代的字符串
            subStr = input.substring(entry.getKey(), entry.getValue());
            //替代的字符
            repStr = Character.toUpperCase(c) == ASCII_A ? "" : String.valueOf((char) (c - 1));
            //替换
            output.replace(entry.getKey(), entry.getValue(), repStr);
        }

        if (!input.equals(output.toString())) {
            System.out.println("-> " + output + ", " + subStr + " is replaced by " + repStr);
            if (output.length() >= CHAR_REP_NUM) {
                replace(output.toString());
            }
        }
    }

    /**
     * 记录需要被删除的字符串的起始下标
     *
     * @param input
     * @return
     */
    private static Map<Integer, Integer> recordRemoveIndex(String input) {
        int count = 1;
        Map<Integer, Integer> removeIndexMap = new TreeMap<>();

        if (CommonUtils.isAllCharSame(input)) {
            removeIndexMap.put(0, input.length());
            return removeIndexMap;
        }

        for (int i = 0, strLength = input.length(); i < strLength - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                if (count >= CHAR_REP_NUM) {
                    removeIndexMap.put(i + 1 - count, i + 1);
                }
                count = 1;
            }
        }
        return removeIndexMap;
    }

}

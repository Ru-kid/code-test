package com.hong.strategy;

import com.hong.constant.GlobalConstant;
import com.hong.utils.CommonUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author hongrunhao
 * @description 替换连续出现三次以上的相同字符
 * @date 2024/02/20 020
 */
public class CrushByReplace implements CrushStrategy {
    @Override
    public void execute(String input) {
        StringBuilder output = new StringBuilder(input);

        Map<Integer, Integer> removeIndexMap = CommonUtils.recordRemoveIndex(input);
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
            repStr = Character.toUpperCase(c) == GlobalConstant.ASCII_A ? "" : String.valueOf((char) (c - 1));
            //替换
            output.replace(entry.getKey(), entry.getValue(), repStr);
        }

        String[] strArray = new String[]{input, output.toString(), subStr, repStr};
        action(strArray, (String[] paramArray) -> {
            System.out.println("-> " + paramArray[1] + ", " + paramArray[2] + " is replaced by " + paramArray[3]);
            if (paramArray[1].length() >= GlobalConstant.CHAR_REP_NUM && !paramArray[0].equals(paramArray[1])) {
                execute(paramArray[1]);
            }
        });
    }
}

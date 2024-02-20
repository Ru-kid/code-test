package com.hong.strategy;

import com.hong.constant.GlobalConstant;
import com.hong.utils.CommonUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author hongrunhao
 * @description 移除连续出现三次以上的相同字符
 * @date 2024/02/20 020
 */
public class CrushByRemove implements CrushStrategy {
    @Override
    public void execute(String input) {
        StringBuilder output = new StringBuilder(input);

        Map<Integer, Integer> removeIndexMap = CommonUtils.recordRemoveIndex(input);
        Iterator it = ((TreeMap<Integer, Integer>) removeIndexMap).descendingMap().entrySet().iterator();
        Map.Entry<Integer, Integer> entry = null;

        while (it.hasNext()) {
            entry = (Map.Entry<Integer, Integer>) it.next();
            //output.delete(entry.getKey(), entry.getValue());
            output.replace(entry.getKey(), entry.getValue(), "");
        }

        String[] strArray = new String[]{input, output.toString()};
        action(strArray, (String[] paramArray) -> {
            System.out.println("-> " + paramArray[1]);
            if (paramArray[1].length() >= GlobalConstant.CHAR_REP_NUM && !paramArray[0].equals(paramArray[1])) {
                execute(paramArray[1]);
            }
        });
    }
}

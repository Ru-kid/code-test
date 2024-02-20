package com.hong.factory;

import com.hong.enums.CrushTypeEnum;
import com.hong.strategy.CrushByRemove;
import com.hong.strategy.CrushByReplace;
import com.hong.strategy.CrushStrategy;

/**
 * @author hongrunhao
 * @description
 * @date 2024/02/20 020
 */
public class CandyCrushFactory {

    public static void configure(String str, Integer strategy) {
        CrushStrategy crushStrategy;
        CrushTypeEnum crushType = CrushTypeEnum.getEnumByCode(strategy);

        switch (crushType) {
            case REMOVE:
                crushStrategy = new CrushByRemove();
                break;
            case REPLACE:
                crushStrategy = new CrushByReplace();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + crushType);
        }

        crushStrategy.execute(str);
    }

}

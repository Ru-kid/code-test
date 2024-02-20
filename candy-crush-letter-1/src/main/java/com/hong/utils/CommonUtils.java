package com.hong.utils;

/**
 * @author hongrunhao
 * @description 通用工具类
 * @date 2024/02/20 019
 */
public class CommonUtils {
    private static CommonUtils instance;

    private CommonUtils() {
        // 私有构造函数
    }

    public static CommonUtils getInstance() {
        if (instance == null) {
            instance = new CommonUtils();
        }
        return instance;
    }

    /**
     * 判断字符是否连续重复三次
     *
     * @param str
     * @return
     */
    public boolean hasConsecutiveThreeDuplicates(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length - 2; i++) {
            if (charArray[i] == charArray[i + 1] && charArray[i] == charArray[i + 2]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取前一个字母
     *
     * @param letter
     * @return
     */
    private static char getPreviousLetter(char letter) {
        if (Character.isLetter(letter)) {
            // 将字符转换为大写形式以确保处理的是字母
            letter = Character.toUpperCase(letter);
            // 将字符转换为 ASCII 值，减去 1，再转回字符
            return (char) (letter - 1);
        } else {
            // 非字母字符，返回原字符
            return letter;
        }
    }

    /**
     * 判断字符串的所有字符是否都是相同的字母
     *
     * @param str
     * @return
     */
    public static boolean isAllCharSame(String str) {
        String upperStr = str.toUpperCase();
        char firstChar = upperStr.charAt(0);
        return upperStr.chars().allMatch(c -> c == firstChar);
    }

}

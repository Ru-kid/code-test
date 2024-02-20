package com.hong;

import com.hong.handle.CandyCrushLetterHandle;

import java.util.Scanner;

/**
 * @author hongrunhao
 * @description For a given string that only contains alphabet characters a-z, if 3 or more consecutive
 * characters are identical, remove them from the string. Repeat this process until
 * there is no more than 3 identical characters sitting besides each other.
 * <p>
 * Example:
 * Input: aabcccbbad
 * Output:
 * -> aabbbad
 * -> aaad
 * -> d
 * <p>
 * Stage 2 - advanced requirement
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
 * @date 2024/02/20 019
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入包含字母 a-z 的字符串：");
        String input = scanner.nextLine();

        CandyCrushLetterHandle.remove(input);
        CandyCrushLetterHandle.replace(input);
    }

}

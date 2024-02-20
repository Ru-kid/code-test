package com.hong;

import com.hong.handle.CandyCrushLetterHandle;
import org.junit.Test;

/**
 * Main Tester.
 *
 * @author hongrunhao
 * @version 1.0
 * @since <pre>2�� 20, 2024</pre>
 */
public class MainTest {

    @Test
    public void testRemoveConsecutiveChars() {

        String input1 = "aabcccbbad";
        CandyCrushLetterHandle.remove(input1);

        String input2 = "aabcccbffffbadb";
        CandyCrushLetterHandle.remove(input2);

        String input3 = "aaaaab";
        CandyCrushLetterHandle.remove(input3);

        String input4 = "aaaaaa";
        CandyCrushLetterHandle.remove(input4);

        String input5 = "abcccbad";
        CandyCrushLetterHandle.replace(input5);

        String input6 = "aabcccbffffbadb";
        CandyCrushLetterHandle.replace(input6);

        String input7 = "aaaaaa";
        CandyCrushLetterHandle.remove(input7);

    }

}

package com.hong.strategy;

import com.hong.strategy.impl.CrushByReplace;
import org.junit.Assert;
import org.junit.Test;

/**
 * CrushByReplace Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>2�� 20, 2024</pre>
 */
public class CrushByReplaceTest {

    /**
     * Method: execute(String input)
     */
    @Test
    public void testExecute() throws Exception {
        CrushByReplace crushByReplace = new CrushByReplace();
        String output = crushByReplace.execute("abcccbad");
        Assert.assertEquals("d", output);
    }

} 

package com.hong.strategy;

import com.hong.strategy.impl.CrushByRemove;
import org.junit.Assert;
import org.junit.Test;

/**
 * CrushByRemove Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>2�� 20, 2024</pre>
 */
public class CrushByRemoveTest {

    /**
     * Method: execute(String input)
     */
    @Test
    public void testExecute() throws Exception {
        CrushByRemove crushByRemove = new CrushByRemove();
        String output = crushByRemove.execute("aabcccbbad");
        Assert.assertEquals("d", output);
    }

} 

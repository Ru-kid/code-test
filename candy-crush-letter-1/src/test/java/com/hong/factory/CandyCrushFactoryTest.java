package com.hong.factory;

import org.junit.Assert;
import org.junit.Test;

/**
 * CandyCrushFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>2�� 20, 2024</pre>
 */
public class CandyCrushFactoryTest {

    /**
     * Method: configure(String str, Integer strategy)
     */
    @Test
    public void testConfigure() throws Exception {
        Assert.assertEquals("a", CandyCrushFactory.configure("a", 1));
        System.out.println();
        Assert.assertEquals("aa", CandyCrushFactory.configure("aa", 1));
        System.out.println();
        Assert.assertEquals("ab", CandyCrushFactory.configure("ab", 1));
        System.out.println();
        Assert.assertEquals("abc", CandyCrushFactory.configure("abc", 1));
        System.out.println();
        Assert.assertEquals("", CandyCrushFactory.configure("aaa", 1));
        System.out.println();
        Assert.assertEquals("", CandyCrushFactory.configure("aaaa", 1));
        System.out.println();
        Assert.assertEquals("b", CandyCrushFactory.configure("aaab", 1));
        System.out.println();
        Assert.assertEquals("b", CandyCrushFactory.configure("aaaab", 1));
        System.out.println();
        Assert.assertEquals("a", CandyCrushFactory.configure("abbb", 1));
        System.out.println();
        Assert.assertEquals("a", CandyCrushFactory.configure("abbbb", 1));
        System.out.println();
        Assert.assertEquals("aa", CandyCrushFactory.configure("abbba", 1));
        System.out.println();
        Assert.assertEquals("aa", CandyCrushFactory.configure("abbbba", 1));
        System.out.println();
        Assert.assertEquals("d", CandyCrushFactory.configure("aabcccbbad", 1));
        System.out.println();
        Assert.assertEquals("db", CandyCrushFactory.configure("aabcccbffffbadb", 1));
        System.out.println();
        Assert.assertEquals("dbb", CandyCrushFactory.configure("aabcccbffffbadbbzzz", 1));
        System.out.println();

        Assert.assertEquals("a", CandyCrushFactory.configure("a", 2));
        System.out.println();
        Assert.assertEquals("aa", CandyCrushFactory.configure("aa", 2));
        System.out.println();
        Assert.assertEquals("ab", CandyCrushFactory.configure("ab", 2));
        System.out.println();
        Assert.assertEquals("abc", CandyCrushFactory.configure("abc", 2));
        System.out.println();
        Assert.assertEquals("", CandyCrushFactory.configure("aaa", 2));
        System.out.println();
        Assert.assertEquals("a", CandyCrushFactory.configure("bbb", 2));
        System.out.println();
        Assert.assertEquals("b", CandyCrushFactory.configure("aaab", 2));
        System.out.println();
        Assert.assertEquals("aa", CandyCrushFactory.configure("abbb", 2));
        System.out.println();
        Assert.assertEquals("", CandyCrushFactory.configure("abbba", 2));
        System.out.println();
        Assert.assertEquals("d", CandyCrushFactory.configure("aabcccbbad", 2));
        System.out.println();
        Assert.assertEquals("ebadb", CandyCrushFactory.configure("aabcccbffffbadb", 2));
        System.out.println();
        Assert.assertEquals("d", CandyCrushFactory.configure("abcccbad", 2));
        System.out.println();
        Assert.assertEquals("ebadbby", CandyCrushFactory.configure("aabcccbffffbadbbzzz", 2));
    }

} 

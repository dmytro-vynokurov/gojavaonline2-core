package com.goit.gojavaonline.core.codegym.unixpath;

import org.junit.Assert;
import org.junit.Test;

public class UnixPathSimplifierTest {

    private UnixPathSimplifier unixPathSimplifier = new UnixPathSimplifier();

    @Test
    public void testSimpleCaseLeftUnchanged() {
        String input = "/here/goes/some/path";

        String result = unixPathSimplifier.simplify(input);

        Assert.assertEquals("Unix path simplification result should be correct", input, result);
    }

    @Test
    public void testDotProcessedCorrectly() {
        String input = "/.";
        String expected = "/";

        String result = unixPathSimplifier.simplify(input);

        Assert.assertEquals("Unix path simplification result should be correct", expected, result);
    }

    @Test
    public void testDoubleSlashProcessedCorrectly() {
        String input = "//";
        String expected = "/";

        String result = unixPathSimplifier.simplify(input);

        Assert.assertEquals("Unix path simplification result should be correct", expected, result);
    }

}
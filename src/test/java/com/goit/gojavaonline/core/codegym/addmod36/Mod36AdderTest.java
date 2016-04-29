package com.goit.gojavaonline.core.codegym.addmod36;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class Mod36AdderTest {

    Mod36Adder mod36Adder = new Mod36Adder();

    @Test
    public void testToDecimalConversion() throws Exception {
        BigInteger actual = mod36Adder.toDecimal("6");
        assertEquals(BigInteger.valueOf(6),actual);
    }
    @Test
    public void testToDecimalConversion2() throws Exception {
        BigInteger actual = mod36Adder.toDecimal("a");
        assertEquals(BigInteger.valueOf(10),actual);
    }
    @Test
    public void testToDecimalConversion3() throws Exception {
        BigInteger actual = mod36Adder.toDecimal("z");
        assertEquals(BigInteger.valueOf(35),actual);
    }

    @Test
    public void testToDecimalConversion4() throws Exception {
        BigInteger actual = mod36Adder.toDecimal("a6");
        assertEquals(BigInteger.valueOf(366),actual);
    }

    @Test
    public void testFromDecimalConversion1() throws Exception {
        String actual = mod36Adder.fromDecimal(BigInteger.valueOf(366));
        assertEquals("a6",actual);
    }

    @Test
    public void testFromDecimalConversion2() throws Exception {
        String actual = mod36Adder.fromDecimal(BigInteger.valueOf(6));
        assertEquals("6",actual);
    }

    @Test
    public void testFromDecimalConversion3() throws Exception {
        String actual = mod36Adder.fromDecimal(BigInteger.valueOf(10));
        assertEquals("a",actual);
    }

    @Test
    public void testadd1() throws Exception {
        String actual = mod36Adder.add("zjfghfhdsdfathjjhgjhghjfjfjhjhdsrreqqklhu456hfz5", "wsfgsgds56346263fgfhghfghfhgfsrr5476hjfgdhdhg3N");
        assertEquals("10g7vy7xrkildxnlpkvzwxy0uzwyyzx6kiwixx24xahmjyw2s",actual);
    }
}
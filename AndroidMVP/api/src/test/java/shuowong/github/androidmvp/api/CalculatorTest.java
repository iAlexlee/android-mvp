package shuowong.github.androidmvp.api;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by WANGSHUO on 12/21/15.
 */
@Deprecated
public class CalculatorTest extends TestCase {
    private Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mCalculator = new Calculator();
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(6d, mCalculator.sum(1d, 5d), 0);
    }

    @Test
    public void testSubstract() throws Exception {
        assertEquals(1d, mCalculator.substract(5d, 4d), 0);
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(4d, mCalculator.divide(20d, 5d), 0);
    }

    @Test
    public void testMultiply() throws Exception {
        assertEquals(10d, mCalculator.multiply(2d, 5d), 0);
    }
}
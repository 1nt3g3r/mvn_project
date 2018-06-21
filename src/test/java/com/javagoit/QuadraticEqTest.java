package com.javagoit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuadraticEqTest {
    private static final double EPSILON = 0.00000000000001D;

    private QuadraticEq eq;

    @Before
    public void prepare() {
        eq = new QuadraticEq();
    }

    @Test
    public void testIfCoeffAIsZero() {
        eq.setA(0);
        double[] roots = eq.findRoots();
        Assert.assertEquals(0, roots.length);
    }

    @Test
    public void testIsEqFull() {
        eq.setCoeffs(1, 2, 3);
        Assert.assertTrue(eq.isFull());
    }

    @Test
    public void testIsEqNotFull() {
        eq.setCoeffs(1, 0, 1);
        Assert.assertFalse(eq.isFull());
    }

    @Test
    public void testIsEqNotFull2() {
        eq.setCoeffs(1, 1, 0);
        Assert.assertFalse(eq.isFull());
    }

    @Test
    public void testValidEq() {
        testEq(1, 1, 5);

        testEq(1, 4, 4,
                -2);

        testEq(1, 6, 6,
                -4.732050807568877d, -1.2679491924311228d);
    }

    public void testEq(int a, int b, int c, double ... expectedRoots) {
        eq.setCoeffs(a, b, c);

        double[] actualRoots = eq.findRoots();

        Assert.assertEquals(expectedRoots.length, actualRoots.length);
        for(int i = 0; i < expectedRoots.length; i++) {
            Assert.assertEquals(expectedRoots[i], actualRoots[i], QuadraticEq.EPSILON);
        }
    }
}

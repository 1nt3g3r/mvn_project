package com.javagoit;

import java.util.Arrays;

public class QuadraticEq {
    public static final double EPSILON = 0.0000000000001d;

    private int a;
    private int b;
    private int c;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setCoeffs(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] findRoots() {
        int discriminant = b*b - 4*a*c;
        if (a == 0 || discriminant < 0) {
            return new double[0];
        }

        double discriminantRoot = Math.sqrt(discriminant);
        double x1 = (-b + discriminantRoot) / (2*a);
        double x2 = (-b - discriminantRoot) / (2*a);

        return simplify(order(x1, x2));
    }

    private double[] simplify(double[] sourceArray) {
        if (Math.abs(sourceArray[0] - sourceArray[1]) < EPSILON) {
            return new double[] {
                    sourceArray[0]
            };
        }

        return sourceArray;
    }

    private double[] order(double x1, double x2) {
        return x1 < x2 ? new double[] {x1, x2} : new double[] {x2, x1};
    }

    public boolean isFull() {
        if (b == 0 || c == 0) {
            return false;
        }

        return true;
    }
}

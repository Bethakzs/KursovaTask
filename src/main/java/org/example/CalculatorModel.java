package org.example;

// model class Calculator
public class CalculatorModel {
    private double a, b, c;

    // constructor with full parameters
    public CalculatorModel(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // method to calculate roots by discriminant
    public double[] calculateRoots() throws IllegalArgumentException {
        double discr = b * b - 4 * a * c;
        if (discr < 0) { // if discriminant is negative, no real roots
            throw new IllegalArgumentException("Discriminant is negative. No real roots.");
        } else if (discr == 0) { // if discriminant is zero, one root
            return new double[]{-b / (2 * a)};
        } else { // default case, two roots
            return new double[]{
                    (-b + Math.sqrt(discr)) / (2 * a),
                    (-b - Math.sqrt(discr)) / (2 * a)
            };
        }
    }
}


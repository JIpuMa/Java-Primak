package com.company.Cw;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class quadratic_equation {
    public void main() throws QuadraticEquationException {
        System.out.println("Input coefficients of quadratic equation (a*x^2 + b*x + c = 0");
        System.out.print("a: ");
        Scanner sc_a = new Scanner(System.in);
        double a = sc_a.nextDouble();
        System.out.print("b: ");
        Scanner sc_b = new Scanner(System.in);
        double b = sc_b.nextDouble();
        System.out.print("c: ");
        Scanner sc_c = new Scanner(System.in);
        double c = sc_c.nextDouble();
        System.out.println("x1, x2 = " + Arrays.toString(root_search(a, b, c)));
    }

    public double[] root_search(double a, double b, double c) throws QuadraticEquationException {
        double[] roots = new double[2];
        if (a == 0.0) {
//            if (b == 0.0) {
//                if (c == 0.0) {
//                    throw new QuadraticEquationException("All coefficients are zero.(x1, x2 є R)");
//                } else {
//                    roots[0] = Double.NaN;
//                    roots[1] = Double.NaN;
//                }
//            } else {
//                if (c == 0.0) {
//                    roots[0] = 0.0;
//                    roots[1] = Double.NaN;
//                } else {
//                    roots[0] = -c / b;
//                    roots[1] = Double.NaN;
//                }
//            }
            throw new QuadraticEquationException(
                    "Coefficients a cannot be zero, cause it's not quadratic equation with it. (a != 0)"
            );
        } else {
            if (b == 0.0) {
                if (c == 0.0) {
                    roots[0] = 0.0;
                    roots[1] = 0.0;
                } else {
                    if (c < 0) {
                        roots[0] = sqrt(-c / a);
                        roots[1] = -sqrt(-c / a);
                    } else {
                        throw new QuadraticEquationException("The square cannot be negative. (x^2 != a, a<0)");
                    }
                }
            } else {
                if (c == 0.0) {
                    roots[0] = 0;
                    roots[1] = -b / a;
                } else {
                    double D = pow(b, 2) - 4 * a * c;
                    if (D >= 0) {
                        double sqrtD = sqrt(D);
                        roots[0] = (-b + sqrtD) / (2 * a);
                        roots[1] = (-b - sqrtD) / (2 * a);
                    } else {
                        throw new QuadraticEquationException("The discriminant is negative. (x1, x2 є R)");
                    }
                }
            }
        }
        return roots;
    }
}

class QuadraticEquationException extends Exception {
    public String message;

    public QuadraticEquationException() {}

    public QuadraticEquationException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Quadratic Equation Exception [" + this.message + "]";
    }
}

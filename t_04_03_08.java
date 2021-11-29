package com.company.Hw;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

public class t_04_03_08 {
    public void main() {
        System.out.print("Input number of quadrangle(s): ");
        Scanner sc_n = new Scanner(System.in);
        int n = sc_n.nextInt();
        Quadrangle[] quads = new Quadrangle[n];
        int n_quads = 0;
        int n_squares = 0;
        int n_diams = 0;
        int n_rects = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Quadrangle " + (i + 1));
            int[] edges = new int[4];
            for (int ed = 0; ed < 4; ed++) {
                System.out.print("Input edge " + (ed + 1) + ": ");
                Scanner sc_ed = new Scanner(System.in);
                edges[ed] = sc_ed.nextInt();
            }
            int[] angles = new int[4];
            for (int an = 0; an < 4; an++) {
                System.out.print("Input angle " + (an + 1) + ": ");
                Scanner sc_ed = new Scanner(System.in);
                angles[an] = sc_ed.nextInt();
            }
            Quadrangle quad = new Quadrangle(edges, angles);
            String type = quad.getType();
            switch (type) {
                case "rectangle" -> n_rects++;
                case "square" -> n_squares++;
                case "diamond" -> n_diams++;
                default -> n_quads++;
            }
            quads[i] = quad;
        }
        if (n_quads == 0) {
            n_quads++;
        }
        if (n_squares == 0) {
            n_squares++;
        }
        if (n_diams == 0) {
            n_diams++;
        }
        if (n_rects == 0) {
            n_rects++;
        }
        Quadrangle[] usual_quads = new Quadrangle[n_quads];
        Quadrangle[] squares = new Quadrangle[n_squares];
        Quadrangle[] diamonds = new Quadrangle[n_diams];
        Quadrangle[] rectangles = new Quadrangle[n_rects];
        int i_q = 0;
        int i_s = 0;
        int i_d = 0;
        int i_r = 0;
        for (Quadrangle quad : quads) {
            String type = quad.getType();
            switch (type) {
                case "rectangle":
                    rectangles[i_r++] = quad;
                    break;
                case "square":
                    squares[i_s++] = quad;
                    break;
                case "diamond":
                    diamonds[i_d++] = quad;
                    break;
                case "quadrangle":
                    usual_quads[i_q++] = quad;
                    break;
                default:
                    System.out.println("404");
            }
        }
        System.out.println("In quadrangles array " +
                "\nSmax = " + Quadrangle.extremeS(usual_quads)[0] +
                "\nSmin = " + Quadrangle.extremeS(usual_quads)[1] +
                "\nPmax = " + Quadrangle.extremeP(usual_quads)[0] +
                "\nPmin = " + Quadrangle.extremeP(usual_quads)[1]);
        System.out.println("In squares array " +
                "\nSmax = " + Quadrangle.extremeS(squares)[0] +
                "\nSmin = " + Quadrangle.extremeS(squares)[1] +
                "\nPmax = " + Quadrangle.extremeP(squares)[0] +
                "\nPmin = " + Quadrangle.extremeP(squares)[1]);
        System.out.println("In diamonds array " +
                "\nSmax = " + Quadrangle.extremeS(diamonds)[0] +
                "\nSmin = " + Quadrangle.extremeS(diamonds)[1] +
                "\nPmax = " + Quadrangle.extremeP(diamonds)[0] +
                "\nPmin = " + Quadrangle.extremeP(diamonds)[1]);
        System.out.println("In rectangles array " +
                "\nSmax = " + Quadrangle.extremeS(rectangles)[0] +
                "\nSmin = " + Quadrangle.extremeS(rectangles)[1] +
                "\nPmax = " + Quadrangle.extremeP(rectangles)[0] +
                "\nPmin = " + Quadrangle.extremeP(rectangles)[1]);
    }
}

class Quadrangle {
    private String type = "quadrangle";
    private int[] edges = new int[4];
    private int[] angles = new int[4];

    public Quadrangle() {
    }

    public Quadrangle(int[] edges, int[] angles) {
        setQuadrangle(edges, angles);
    }

    public void setQuadrangle(int[] edges, int[] angles) {
        setEdges(edges);
        setAngles(angles);
        defineType();
    }

    public Quadrangle getQuadrangle() {
        return this;
    }

    public void setEdges(int[] edges) {
        this.edges = edges;
    }

    public void setAngles(int[] angles) {
        this.angles = angles;
    }

    public int[] getEdges() {
        return this.edges;
    }

    public int[] getAngles() {
        return this.angles;
    }

    public String getType() {
        return this.type;
    }

    public void defineType() {
        if ((this.edges[0] == this.edges[1])
                && (this.edges[1] == this.edges[2])) {
            if ((this.angles[0] == this.angles[2])
                    && (this.angles[0] == 90)) {
                this.type = "square";
            } else {
                this.type = "diamond";
            }
        } else if ((this.edges[0] == this.edges[2])
                && (this.edges[1] == this.edges[3])
                && (this.angles[0] == 90)) {
            this.type = "rectangle";
        }
    }

    public int calcP() {
        return Arrays.stream(this.edges).sum();
    }

    public double calcS() {
        int p = calcP() / 2;
        return sqrt((p - this.edges[0]) *
                (p - this.edges[1]) *
                (p - this.edges[2]) *
                (p - this.edges[3]) -
                this.edges[0] * this.edges[1] *
                        this.edges[2] * this.edges[3] *
                        pow(cos(((this.angles[0] + this.angles[2]) * PI) / 360), 2)
        );
    }

    @Override
    public String toString() {
        return this.type +
                ": \nedges: " +
                Arrays.toString(this.edges) +
                "\nangles: " +
                Arrays.toString(this.angles);
    }

    public static int[] extremeP(Quadrangle[] quads) {
        if (quads[0] == null) {
            return new int[]{0, 0};
        }
        int max = quads[0].calcP();
        int min = quads[0].calcP();
        for (Quadrangle quad : quads) {
            int P = quad.calcP();
            if (P > max) {
                max = P;
            }
            if (P < min) {
                min = P;
            }
        }
        return new int[]{max, min};
    }

    public static double[] extremeS(Quadrangle[] quads) {
        if (quads[0] == null) {
            return new double[]{0.0, 0.0};
        }
        double max = quads[0].calcS();
        double min = quads[0].calcS();
        for (Quadrangle quad : quads) {
            double S = quad.calcS();
            if (S > max) {
                max = S;
            }
            if (S < min) {
                min = S;
            }
        }
        return new double[]{max, min};
    }
}

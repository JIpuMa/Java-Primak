package com.company.Cw;

public class t_02_03_05 {
    public void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        int num4 = Integer.parseInt(args[3]);
        int num5 = Integer.parseInt(args[4]);
        if (median(num1, num2, num3, num4, num5)) {
            System.out.println("Median: " + num1);
        }
        if (median(num2, num1, num3, num4, num5)) {
            System.out.println("Median: " + num2);
        }
        if (median(num3, num2, num1, num4, num5)) {
            System.out.println("Median: " + num3);
        }
        if (median(num4, num2, num3, num1, num5)) {
            System.out.println("Median: " + num4);
        }
        if (median(num5, num2, num3, num4, num1)) {
            System.out.println("Median: " + num5);
        }
    }

    private boolean median(int num1, int num2, int num3, int num4, int num5) {
        if (num1 < num2) {
            if (num1 < num3) {
                return (num1 > num4) & (num1 > num5);
            } else {
                return ((num1 < num4) & (num1 > num5)) | ((num1 > num4) & (num1 < num5));
            }
        } else {
            if (num1 > num3) {
                return (num1 < num4) & (num1 < num5);
            } else {
                return ((num1 < num4) & (num1 > num5)) | ((num1 > num4) & (num1 < num5));
            }
        }
    }
}

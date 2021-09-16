package com.company.Cw;

public class t_02_02_01 {
    public void main() {
        int i1 = 160;
        int i2 = 161;
        System.out.println("x = " + Integer.toBinaryString(i1));
        System.out.println("y = " + Integer.toBinaryString(i2));
        System.out.println("~x:" + Integer.toBinaryString(~i1));
        System.out.println("x&y:" + Integer.toBinaryString(i1 & i2));
        System.out.println("x|y:" + Integer.toBinaryString(i1 | i2));
        System.out.println("x^y" + Integer.toBinaryString(i1 ^ i2));
    }
}

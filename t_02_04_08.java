package com.company.Hw;

public class t_02_04_08 {
    public void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        if ((num1 == num2) & (num2 == num3)) {
            System.out.println("рівні");
        } else {
            System.out.println("не рівні");
        }
    }
}

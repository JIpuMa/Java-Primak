package com.company.Cw;

import java.util.Random;

public class t_02_03_02 {
    public void main() {
        for (int i = 0; i < 25; i++) {
            String sign;
            Random rd1 = new Random();
            int num1 = rd1.nextInt(100);
            Random rd2 = new Random();
            int num2 = rd2.nextInt(100);
            if (num1 < num2) {
                sign = "<";
            } else if (num1 > num2) {
                sign = ">";
            } else {
                sign = "=";
            }
            System.out.printf("%d) for %d: %d %s %d\n", i + 1, num1, num1, sign, num2);
        }
    }
}

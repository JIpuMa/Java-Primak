package com.company.Cw;

public class t_01_03_04 {
    public void main() {
        float num1_f = (float) Math.pow(10, -4),
                num2_f = (float) 2.33e5,
                num3_f = (float) Math.PI,
                num4_f = (float) Math.exp(1),
                num5_f = (float) Math.pow(5, (double) 1 / 3),
                num6_f = (float) Math.log(100);
        double num1_d = Math.pow(10, -4),
                num2_d = 2.33e5,
                num3_d = Math.PI,
                num4_d = Math.exp(1),
                num5_d = Math.pow(5, (double) 1 / 3),
                num6_d = Math.log(100);
        long num1_l = (long) Math.pow(10, -4),
                num2_l = (long) 2.33e5,
                num3_l = (long) Math.PI,
                num4_l = (long) Math.exp(1),
                num5_l = (long) Math.pow(5, (double) 1 / 3),
                num6_l = (long) Math.log(100);
        System.out.println("Стандартні числа: 10^(-4), 2.33e5, п, e, qrt5, ln(100)");
        System.out.printf("Дійсні числа: %s, %s, %s, %s, %s, %s\n",
                num1_f, num2_f, num3_f, num4_f, num5_f, num6_f);
        System.out.printf("Подвійні дійсні числа: %s, %s, %s, %s, %s, %s\n",
                num1_d, num2_d, num3_d, num4_d, num5_d, num6_d);
        System.out.printf("Довгі цілі числа: %s, %s, %s, %s, %s, %s\n",
                num1_l, num2_l, num3_l, num4_l, num5_l, num6_l);
    }
}

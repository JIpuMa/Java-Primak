package com.company.Cw;

import java.util.Scanner;

public class t_02_02_04 {
    public void main() {
        System.out.print("n = ");
        Scanner scan1 = new Scanner(System.in);
        int n = scan1.nextInt();
        System.out.print("m = ");
        Scanner scan2 = new Scanner(System.in);
        int m = scan2.nextInt();
        n = n ^ 1 << m;
        System.out.println("result: " + n);
    }
}

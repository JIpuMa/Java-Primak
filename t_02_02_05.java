package com.company.Cw;

import java.util.Scanner;

public class t_02_02_05 {
    public void main() {
        System.out.print("n = ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int len = Integer.toBinaryString(n).length();
        len--;
        n ^= 1 << len;
        n <<= 1;
        n ^= 1 << 0;
        System.out.println("result: " + n);
    }
}

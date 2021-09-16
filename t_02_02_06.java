package com.company.Cw;

import java.util.Scanner;

public class t_02_02_06 {
    public void main() {
        System.out.print("n(in bytes) = ");
        Scanner scan = new Scanner(System.in);
        String bit_n = scan.next();
        int n = Integer.parseInt(bit_n, 2);
        int len = Integer.toBinaryString(n).length() - 1;
        int cur = 3;
        int count = 0;
        while (len > 0) {
            int n_copy = n;
            if (n == (n_copy | cur)) {
                count += 1;
            }
            cur <<= 1;
            len--;
        }
        System.out.println("result: " + count);
    }
}

package com.company.Hw;

import java.util.Scanner;

public class t_02_02_18 {
    public void main() {
        System.out.print("input: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] args = input.split("\\s", 0);
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int bit = Integer.parseInt(args[2]);
        n = (n & ~(1 << (m - 1))) | ((bit << (m - 1)) & (1 << (m - 1)));
        System.out.println("result: " + n + " " + Integer.toHexString(n) + " " + Integer.toBinaryString(n));
    }
}

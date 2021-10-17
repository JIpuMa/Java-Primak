package com.company.Cw;

import java.util.Scanner;

public class t_03_01_04 {
    public void main() {
        Scanner sc = new Scanner(System.in);
        int prev = 0;
        int max = 0;
        int max_count = 0;
        int cur_count = 1;
        while (sc.hasNextInt()) {
            int cur = sc.nextInt();
            if (cur == 0) {
                break;
            }
            if (cur == prev) {
                cur_count++;
            }
            else {
                if (max_count == cur_count) {
                    if (max < cur) {
                        max = prev;
                    }
                }
                if (max_count < cur_count) {
                    max_count = cur_count;
                    max = prev;
                }
                cur_count = 1;
            }
            prev = cur;
        }
        System.out.println(max_count + " підряд чисел " + max);
    }
}

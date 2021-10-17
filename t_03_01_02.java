package com.company.Cw;

import java.util.Scanner;

public class t_03_01_02 {
    public void main() {
        System.out.print("Input numbers: ");
        int count = 1;
        int max_num = 0, min_num = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int cur_num = sc.nextInt();
            if (cur_num == 0) {
                break;
            }
            if (count == 1) {
                max_num = cur_num;
                min_num = cur_num;
            }
            if (cur_num > max_num) {
                max_num = cur_num;
            }
            if (cur_num < min_num) {
                min_num = cur_num;
            }
            count++;
        }
        System.out.println("Max: " + max_num);
        System.out.println("Min: " + min_num);
    }
}

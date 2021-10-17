package com.company.Cw;

import java.util.Scanner;

public class t_03_01_06 {
    public void main() {
        System.out.print("n: ");
        Scanner sc_n = new Scanner(System.in);
        int n = sc_n.nextInt();
        int min = 0;
        int arr_i = 0;
        int[] ans_arr = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Input element " + i + ": ");
            Scanner sc_el = new Scanner(System.in);
            int el = sc_el.nextInt();
            arr[i] = el;
            String str_el = String.valueOf(el);
            int len_str_el = str_el.length();
            if (i == 0) {
                min = len_str_el;
                ans_arr[arr_i] = el;
                arr_i++;
            } else {
                if (len_str_el < min) {
                    ans_arr = new int[n];
                    arr_i = 0;
                    min = len_str_el;
                    ans_arr[arr_i] = el;
                    arr_i++;
                } else if (len_str_el == min) {
                    ans_arr[arr_i] = el;
                    arr_i++;
                }
            }
        }
        System.out.print("Number(s) with the least number of digits: ");
        for (int ans: ans_arr) {
            if (ans == 0) { break; }
            System.out.print(ans + " ");
        }
    }
}

package com.company.Hw;

import java.util.Arrays;
import java.util.Scanner;

public class t_03_01_08 {
    public void main() {
        System.out.print("n: ");
        Scanner sc_n = new Scanner(System.in);
        int n = sc_n.nextInt();
        int arr_i = 0;
        int[] ans_arr = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Input element " + i + ": ");
            Scanner sc_el = new Scanner(System.in);
            int el = sc_el.nextInt();
            arr[i] = el;
            String str_el = String.valueOf(el);
            if ((str_el.equals(sort_str(str_el))) & (str_el.length() != 1)) {
                ans_arr[arr_i] = el;
                arr_i++;
            }
        }
        System.out.print("Number(s) with the sorted digits: ");
        for (int ans: ans_arr) {
            if (ans == 0) { break; }
            System.out.print(ans + " ");
        }
    }

    public String sort_str(String input_str) {
        char[] temp_arr = input_str.toCharArray();
        Arrays.sort(temp_arr);
        return new String(temp_arr);
    }
}

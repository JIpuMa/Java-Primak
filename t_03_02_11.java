package com.company.Hw;

import java.util.Scanner;
import java.util.Objects;
import java.util.Random;

public class t_03_02_11 {
    public void main() {
        System.out.print("n: ");
        Scanner sc_n = new Scanner(System.in);
        int n = sc_n.nextInt();
        System.out.print("Console or random ? (c/r): ");
        Scanner sc_check = new Scanner(System.in);
        String check = sc_check.next();
        int[][] matrix;
        if (Objects.equals(check, "c")) {
            matrix = input_console(n);
            System.out.println("Your matrix:");
            show_matrix(matrix);
        } else {
            matrix = input_random(n);
            System.out.println("Your matrix:");
            show_matrix(matrix);
        }
        int[][] new_matrix = matrix_compaction(matrix, 0);
        if (new_matrix.length == 0) {
            System.out.println("Empty matrix");
        } else {
            System.out.println("Compacting matrix:");
            show_matrix(new_matrix);
        }
    }

    int[][] matrix_compaction(int[][] array, int z) {
        int i_int = array.length;
        boolean[] i_arr = new boolean[i_int];
        for (int i = 0; i < array.length; i++) {
            i_arr[i] = true;
        }
        int j_int = array[0].length;
        boolean[] j_arr = new boolean[array[0].length];
        for (int j = 0; j < array[0].length; j++) {
            j_arr[j] = true;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) {
                    if (i_arr[i]) {
                        i_int--;
                    }
                    i_arr[i] = false;
                    if (j_arr[j]) {
                        j_int--;
                    }
                    j_arr[j] = false;
                }
            }
        }
        if ((i_int == 0) | (j_int == 0)) {
            return new int[0][0];
        }
        int[][] new_array = new int[i_int][j_int];
        int i_n = 0;
        int j_n = 0;
        for (int i = 0; i < array.length; i++) {
            if (i_arr[i]) {
                for (int j = 0; j < array[0].length; j++) {
                    if (j_arr[j]) {
                        new_array[i_n][j_n] = array[i][j];
                        j_n++;
                        j_n %= j_int;
                    }
                }
                i_n++;
                i_n %= i_int;
            }
        }
        return new_array;
    }

    int[][] input_console(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Input a[%d][%d]: ", i + 1, j + 1);
                Scanner sc = new Scanner(System.in);
                array[i][j] = sc.nextInt();
            }
        }
        return array;
    }

    int[][] input_random(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Random rd = new Random();
                array[i][j] = rd.nextInt(2 * n) - n;
            }
        }
        return array;
    }

    static void show_matrix(int[][] array) {
        for (int[] row : array) {
            for (int el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}

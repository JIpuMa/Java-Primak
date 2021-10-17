package com.company.Cw;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class t_03_02_02 {
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
        System.out.print("k: ");
        Scanner sc_k = new Scanner(System.in);
        int k = sc_k.nextInt();
        int[][] matrix_cycl = cyclic_shift(matrix, k);
        show_matrix(matrix_cycl);
    }

    int[][] cyclic_shift(int[][] array, int k) {
        for (int i = 0; i < array.length; i++) {
            int[] row = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                row[j] = array[i][(j + k) % array[i].length];
            }
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = row[j];
            }
        }
        return array;
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

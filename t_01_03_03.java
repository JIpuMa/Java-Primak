package com.company.Cw;

import java.util.Scanner;

public class t_01_03_03 {
    public void main() {
        System.out.println("Введіть ім'я: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.printf("Привіт, %s!\n", name);
    }
}

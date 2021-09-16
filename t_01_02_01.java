package com.company.Cw;

import java.util.Scanner;

public class t_01_02_01 {
    public void main() {
        System.out.print("Введіть прізвище: ");
        Scanner scan = new Scanner(System.in);
        String surname = scan.next();
        System.out.println("Привіт, " + surname);
    }
}

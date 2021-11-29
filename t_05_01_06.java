package com.company.Cw;

import java.util.Scanner;

public class t_05_01_06 {
    public void main() {
        System.out.print("Input string: ");
        Scanner sc = new Scanner(System.in);
        StringBuffer string = new StringBuffer(sc.nextLine());
        string.append(" that we use to illustrate the methods of class StringBuffer");
        System.out.println("New string: " + string);
    }
}

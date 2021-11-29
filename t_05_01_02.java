package com.company.Cw;

import java.util.Scanner;

public class t_05_01_02 {
    public void main(String[] args) {
        System.out.print("Input text: ");
        Scanner sc = new Scanner(System.in);
        StringBuffer text1 = new StringBuffer(sc.nextLine());
        text1.reverse();
        System.out.println("Reverse text from console: " + text1);
        StringBuffer text2 = new StringBuffer(String.join(" ", args));
        text2.reverse();
        System.out.println("Reverse text from program: " + text2);
    }
}

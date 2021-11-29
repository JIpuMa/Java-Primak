package com.company.Cw;

import java.util.Scanner;
import java.util.StringTokenizer;

public class t_05_01_01 {
    public void main(String[] args) {
        System.out.print("Input text: ");
        Scanner sc = new Scanner(System.in);
        int l1 = new StringTokenizer(sc.nextLine(), "\t\n\s,.!?-;:").countTokens();
        System.out.println("Length of text from console: " + l1);
        int l2 = args.length;
        System.out.println("Length of text from program: " + l2);
    }
}

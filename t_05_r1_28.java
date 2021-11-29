package com.company.Hw;

import java.util.Scanner;

public class t_05_r1_28 {
    public void main() {
        System.out.print("Input text: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        StringBuffer left = new StringBuffer(text.substring(0, text.length() / 2));
        StringBuffer right = new StringBuffer(text.substring(text.length() / 2));
        right.reverse();
        String sleft = new String(left);
        String sright = new String(right);
        String new_text = null;
        boolean stop = false;
        for (int i = 0; i < text.length() / 2; i++) {
            if (sleft.charAt(i) != sright.charAt(i)) {
                stop = true;
                System.out.println(i-1 + " " + (text.length()-i+1));
                new_text = text.substring(i-1, text.length()-i+1);
            }
        }
        if (!stop) {
            if (sleft.length() == sright.length()) {
                new_text = "";
            } else {
                new_text = text.substring(text.length() / 2, text.length() / 2 + 1);
            }
        }
        System.out.println("Changed text: " + new_text);
    }
}

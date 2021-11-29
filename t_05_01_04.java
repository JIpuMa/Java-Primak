package com.company.Cw;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t_05_01_04 {
    public void main() {
        System.out.print("Input text: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String new_text = text.replaceAll("a |an ", "");
        System.out.println("Changed text: " + new_text);
    }
}

package com.company.Cw;

import javax.swing.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t_05_01_03 {
    public void main() {
        System.out.print("Input text: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String new_text = text.replaceAll("small", "very large");
        System.out.println("Changed text: " + new_text);
    }
}

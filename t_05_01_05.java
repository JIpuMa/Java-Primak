package com.company.Cw;

import java.util.Scanner;

public class t_05_01_05 {
    public void main() {
        System.out.print("Input text: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        text = text.replaceAll("small", "very small");
        text = text.replaceAll("large", "very large");
        System.out.println("Changed text: " + text);
    }
}

package com.company.Cw;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t_05_01_08 {
    public void main(String[] args) {
        System.out.print("Input text: ");
        Scanner sc_text = new Scanner(System.in);
        String text = sc_text.nextLine();
        System.out.print("Input word: ");
        Scanner sc_word = new Scanner(System.in);
        String word = sc_word.nextLine();
        System.out.println("For text inputted from console:");
        System.out.println("- case sensitive: " + containsWithCase(text, word));
        System.out.println("- case insensitive: " + containsWithoutCase(text, word));
        String new_text = String.join(" ", args);
        System.out.println("For text inputted from program:");
        System.out.println("- case sensitive: " + containsWithCase(new_text, word));
        System.out.println("- case insensitive: " + containsWithoutCase(new_text, word));
    }

    public boolean containsWithCase(String text, String word) {
        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public boolean containsWithoutCase(String text, String word) {
        Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}

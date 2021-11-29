package com.company.Cw;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t_05_01_07 {
    public void main(String[] args) {
        System.out.print("Input text: ");
        Scanner sc_text = new Scanner(System.in);
        String text = sc_text.nextLine();
        System.out.println("For text inputted from console:");
        System.out.println("Symbols: " + text.length());
        System.out.println("Words: " + new StringTokenizer(text, "\t\n\s,.!?-;:").countTokens());
        Pattern pattern = Pattern.compile("[^[,.!?:;-]]*[,.!?:;-]");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {count++;}
        System.out.println("Signs: " + count);
        Pattern pattern1 = Pattern.compile("[^[.!?]]*[.!?]");
        Matcher matcher1 = pattern1.matcher(text);
        int count1 = 0;
        while (matcher1.find()) {count1++;}
        System.out.println("Sentences: " + count1);

        String new_text = String.join(" ", args);
        System.out.println("For text inputted from program:");
        System.out.println("Symbols: " + new_text.length());
        System.out.println("Words: " + args.length);
        Pattern new_pattern = Pattern.compile("[^[,.!?:;-]]*[,.!?:;-]");
        Matcher new_matcher = new_pattern.matcher(new_text);
        int new_count = 0;
        while (new_matcher.find()) {new_count++;}
        System.out.println("Signs: " + new_count);
        Pattern new_pattern1 = Pattern.compile("[^[.!?]]*[.!?]");
        Matcher new_matcher1 = new_pattern1.matcher(new_text);
        int new_count1 = 0;
        while (new_matcher1.find()) {new_count1++;}
        System.out.println("Sentences: " + new_count1);
    }
}

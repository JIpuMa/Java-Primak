package com.company.Hw;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t_05_r2_15 {
    public void main() {
        System.out.print("Input text: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.print("Input n: ");
        Scanner sc_n = new Scanner(System.in);
        int n = sc_n.nextInt();
        System.out.println("a) " + a(text));
        System.out.println("b) " + b(text, n));
        System.out.println("c) " + c(text));
        System.out.println("d) " + d(text));
    }

    public boolean a(String text) {
        boolean answer = false;
        String[] words = text.split(" ");
        if (words.length != 2) {
            return answer;
        }
        StringBuilder word1 = new StringBuilder(words[0]);
        word1.reverse();
        Pattern pattern = Pattern.compile(String.valueOf(word1));
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            answer = true;
        }
        return answer;
    }

    public boolean b(String text, int n) {
        boolean answer = false;
        String[] words = text.split(" ");
        if (words.length != n) {
            return answer;
        }
        for (int i = 0; i < n; i++) {
            Pattern pattern = Pattern.compile(String.valueOf(new StringBuilder(words[i]).reverse()));
            Matcher matcher = pattern.matcher(text);
            if (!matcher.find()) {
                return answer;
            }
        }
        answer = true;
        return answer;
    }

    public boolean c(String text) {
        boolean answer = false;
        Pattern pattern = Pattern.compile("[IVXLCDM\s]");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll("");
        if (text.equals("")) {
            answer = true;
        }
        return answer;
    }

    public boolean d(String text) {
        boolean answer = false;
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            answer = true;
        }
        return answer;
    }
}

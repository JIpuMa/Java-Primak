package com.company.Cw;

public class t_02_03_04 {
    public void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int diff_means;
        if ((a == b) & (b == c)) {
            diff_means = 1;
        } else if (((a == b) & (b != c)) |
                ((b == c) & (a != c)) |
                ((a == c) & (a != b))) {
            diff_means = 2;
        } else {
            diff_means = 3;
        }
        System.out.println("Different mean(s): " + diff_means);
    }
}

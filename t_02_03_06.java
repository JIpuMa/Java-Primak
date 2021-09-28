package com.company.Cw;

import java.util.Random;

public class t_02_03_06 {
    public void main() {
        int correct = 0, all = 1000;
        for (int i = 0; i < all; i++) {
            if (one_rep()) {
                correct++;
            }
        }
        System.out.println((float)correct/all);
    }

    private boolean one_rep() {
        boolean a = false, b = false;
        int a_count = 0, b_count = 0;
        int count = 1;
        int prev = -1;
        do {
            Random rd = new Random();
            int monet = rd.nextInt(2);
            if (prev == 1) {
                if (monet == 1) {
                    a = true;
                    a_count = count;
                } else {
                    b = true;
                    b_count = count;
                }
            }
            prev = monet;
            count++;
        } while (!(a & b));
        return a_count < b_count;
    }
}

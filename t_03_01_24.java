package com.company.Hw;

public class t_03_01_24 {
    public void main(String[] args) {
        int sum = 0;
        char[] code_9num = args[0].toCharArray();
        for (int i = 0; i < 9; i++) {
            int cur = Integer.parseInt(String.valueOf(code_9num[i]));
            sum += cur * (10 - i);
        }
        int last_num = -1;
        for (int i = 0; i < 11; i++) {
            if ((sum + i) % 11 == 0) {
                last_num = i;
            }
        }
        String answer = null;
        for (int i = 0; i < 9; i++) {
            if (answer == null) {
                answer = String.valueOf(code_9num[i]);
            } else {
                answer += String.valueOf(code_9num[i]);
            }
            if ((i == 0) | (i == 3) | (i == 8)) {
                answer += "-";
            }
        }
        answer += String.valueOf(last_num);
        System.out.println("ISBN: " + answer);
    }
}

package com.company.Cw;

public class t_01_01_06 {
    public void main(String[] args) {
        float sum = 0;
        int num_floats = 0;
        for (String num : args) {
            if (num.matches("\\d*[.]\\d+")) {
                num_floats++;
            }
            sum += Float.parseFloat(num);
        }
        System.out.println("result: " + sum);
        System.out.println("number floats: " + num_floats);
    }
}

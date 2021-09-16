package com.company.Cw;

public class t_02_02_02 {
    public void main() {
        int i1 = 21;
        int i2 = (i1 << 1);
        int len = Integer.toBinaryString(i2).length();
        System.out.println(i1);
        System.out.println(i2);
        do {
            i2 = i2 >>> 1;
            System.out.println(Integer.toBinaryString(i2));
            len--;
        } while (len > 0);
    }
}

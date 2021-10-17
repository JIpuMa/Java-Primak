package com.company.Cw;

public class t_03_03_02 {
    public void main() {
        Rows r = new Rows("second row");
        System.out.println("r1: " + r.r1);
        System.out.println("r2: " + r.r2);
        System.out.println("Initialization in constructor will be later than usual variable initialization inside of the class");
    }
}

class Rows {
    public String r1 = "first row";
    public String r2;

    public Rows(String r2) {
        this.r2 = r2;
    }
}

package com.company.Cw.pack_t_04_01_03;

public class pack_t_04_01_03 {
    public String publ_s = "public variable";
    protected String prot_s = "protected variable";
    private String priv_s = "private variable";

    public void publ_hello() {
        System.out.println("Hello from public method");
    }

    protected void prot_hello() {
        System.out.println("Hello from protected method");
    }

    private void priv_hello() {
        System.out.println("Hello from private method");
    }
}

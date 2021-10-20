package com.company.Cw;

public class t_04_01_04 {
    public void main() {
        printType();
        setType("public");
        printType();
    }

    public void printType() {
        System.out.println(ProtectedClass.type);
    }
    public void setType(String new_type) {
        ProtectedClass.type = new_type;
    }
}

class ProtectedClass {
    protected static String type = "protected";
}

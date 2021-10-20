package com.company.Cw.pack_t_04_01_05_debugoff;

public class debug {
    public static void main() {
        printDebug("aa", "bb");
    }

    public static void printDebug(String... args) {
        if (args.length == 0) {
            System.out.println("There are no arguments");
            return;
        }
    }
}

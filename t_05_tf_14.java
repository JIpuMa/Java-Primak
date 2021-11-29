package com.company.Hw;

import java.io.*;
import java.util.Scanner;

public class t_05_tf_14 {
    public static final String filePath = "C:\\Users\\Ярослав\\Desktop\\Python\\" +
            "Semester 5\\Java_Course\\src\\com\\company\\Cw\\";

    public void main() throws FileNotFoundException {
        System.out.print("Input file name: ");
        Scanner sc_file = new Scanner(System.in);
        String file = sc_file.next();
        System.out.print("Input person name: ");
        Scanner sc_name = new Scanner(System.in);
        String[] name = sc_name.nextLine().split("\s");
        System.out.println("Number: " + number_search(file, name));
    }

    public String number_search(String file, String[] name) throws FileNotFoundException {
        String number = null;
        FileReader fr = new FileReader(filePath + file);
        BufferedReader br = new BufferedReader(fr);
        Scanner input = new Scanner(br);
        while (input.hasNextLine()) {
            String[] row = input.nextLine().split("\s");
            if ((row[0].equals(name[0]) &&
                    row[1].equals(name[1]) &&
                    row[2].equals(name[2]))) {
                number = row[3];
            }
        }
        input.close();
        return number;
    }
}

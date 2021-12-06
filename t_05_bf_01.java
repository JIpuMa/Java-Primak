package com.company.Cw;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class t_05_bf_01 {
    public void main() {
        System.out.println("Task 1:");
        random_numbers();
        System.out.println("Task 2:");
        multiply_even_numbers();
        System.out.println("Task 3:");
        first_change();
        System.out.println("Task 4:");
        second_change();
    }

    public void random_numbers() {
        Random random = new Random();
        System.out.print("Input n: ");
        Scanner sc_n = new Scanner(System.in);
        int n = sc_n.nextInt();
        System.out.print("Input filename: ");
        Scanner sc_fn = new Scanner(System.in);
        String filename = sc_fn.next();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }
        writeBinaryFile(filename, array);
    }

    public void multiply_even_numbers() {
        System.out.print("Input filename to read: ");
        Scanner sc_fn = new Scanner(System.in);
        String file_read = sc_fn.next();
        System.out.print("Input filename to write: ");
        Scanner sc_wn = new Scanner(System.in);
        String file_write = sc_wn.next();
        int[] start_file = readBinaryFile(file_read);
        assert start_file != null;
        int mul = 1;
        for (int i = 0; i < start_file.length; i++) {
            if (i % 2 == 1) {
                mul *= start_file[i];
            }
        }
        int[] end_file = new int[] {mul};
        writeBinaryFile(file_write, end_file);
    }

    public void first_change() {
        System.out.print("Input filename to read: ");
        Scanner sc_fn = new Scanner(System.in);
        String file_read = sc_fn.next();
        System.out.print("Input filename to write: ");
        Scanner sc_wn = new Scanner(System.in);
        String file_write = sc_wn.next();
        int[] start_file = readBinaryFile(file_read);
        assert start_file != null;
        int[] end_file = new int[start_file.length];
        for (int i = 0; i < start_file.length; i++) {
            if (start_file[i] < 0) {
                end_file[i] = start_file[i] * (-1);
            } else {
                end_file[i] = 0;
            }
        }
        writeBinaryFile(file_write, end_file);
    }

    public void second_change() {
        System.out.print("Input filename to read: ");
        Scanner sc_fn = new Scanner(System.in);
        String file_read = sc_fn.next();
        System.out.print ("Input filename to write: ");
        Scanner sc_wn = new Scanner(System.in);
        String file_write = sc_wn.next();
        int[] start_file = readBinaryFile(file_read);
        assert start_file != null;
        int[] end_file = new int[start_file.length];
        for (int i = 0; i < start_file.length; i++) {
            if (i % 2 == 0) {
                end_file[i] = start_file[i] * 2;
            } else {
                end_file[i] = start_file[i] / 2;
            }
        }
        writeBinaryFile(file_write, end_file);
    }

    public static void writeBinaryFile(String filename, int[] array) {
        FileOutputStream fos;
        BufferedOutputStream bos;
        DataOutputStream dos;

        try {
            fos = new FileOutputStream(filename);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);

            for (int n : array)
                dos.writeInt(n);

            dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readBinaryFile(String filename) {
        FileInputStream fis;
        BufferedInputStream bis;
        DataInputStream dis;

        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            File file = new File(filename);
            long size = file.length();
            int count = (int) size / Integer.BYTES;
            int[] array = new int[count];
            for (int i = 0; i < count; i++)
                array[i] = dis.readInt();

            dis.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

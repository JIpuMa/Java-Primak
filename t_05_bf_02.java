package com.company.Cw;

import java.io.*;
import java.util.Scanner;

public class t_05_bf_02 {
    public void main() {
        System.out.println("Task 1:");
        input_numbers();
        System.out.println("Task 2:");
        sum_numbers();
        System.out.println("Task 3:");
        multiply_numbers();
    }

    public void input_numbers() {
        System.out.print("Input n: ");
        Scanner sc_n = new Scanner(System.in);
        int n = sc_n.nextInt();
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("El " + (i + 1) + ": ");
            Scanner sc_el = new Scanner(System.in);
            double el = sc_el.nextDouble();
            array[i] = el;
        }
        System.out.print("Input filename: ");
        Scanner sc_fn = new Scanner(System.in);
        String filename = sc_fn.next();
        writeBinaryFile(filename, array);
    }

    public void sum_numbers() {
        System.out.print("Input filename: ");
        Scanner sc_fn = new Scanner(System.in);
        String filename = sc_fn.next();
        double[] array = readBinaryFile(filename);
        assert array != null;
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Sum: " + sum);
    }

    public void multiply_numbers() {
        System.out.print("Input filename to read: ");
        Scanner sc_rn = new Scanner(System.in);
        String file_read = sc_rn.next();
        System.out.print("Input filename to write: ");
        Scanner sc_wn = new Scanner(System.in);
        String file_write = sc_wn.next();
        double[] array = readBinaryFile(file_read);
        assert array != null;
        double mul = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                mul *= Math.abs(array[i]);
            }
        }
        double[] ans = new double[] {mul};
        writeBinaryFile(file_write, ans);
    }

    public static void writeBinaryFile(String filename, double[] array) {
        FileOutputStream fos;
        BufferedOutputStream bos;
        DataOutputStream dos;

        try {
            fos = new FileOutputStream(filename);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);

            for (double n : array)
                dos.writeDouble(n);

            dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[] readBinaryFile(String filename) {
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
            double[] array = new double[count];
            for (int i = 0; i < count; i++)
                array[i] = dis.readDouble();

            dis.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

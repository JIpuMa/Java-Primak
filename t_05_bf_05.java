package com.company.Hw;

import java.io.*;
import java.util.Scanner;

public class t_05_bf_05 {
    public void main() {
        int[] components = new int[]{1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 5};
        System.out.print("Input n: ");
        Scanner sc_n = new Scanner(System.in);
        int n = sc_n.nextInt();
        writeBinaryFile("F.integer", components);
        int[] file_comps = readBinaryFile("F.integer");
        assert file_comps != null;
        int[] new_components = rewriteComponents(file_comps, n);
        writeBinaryFile("G.integer", new_components);
    }

    public int[] rewriteComponents(int[] components, int n) {
        int m = components.length;
        int new_size = m % n == 0 ? m / n : m / n + 1;
        int[] new_components = new int[new_size];
        int cur_max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (cur_max < components[i]) {
                cur_max = components[i];
            }
            if ((i + 1) % n == 0) {
                new_components[i / n] = cur_max;
                cur_max = Integer.MIN_VALUE;
            } else if ((i + 1) / n == m / n && i == m - 1) {
                new_components[m / n] = cur_max;
            }
        }
        return new_components;
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

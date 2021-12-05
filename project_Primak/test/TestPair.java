package com.company.project_Primak.test;

import com.company.project_Primak.src.Csv;
import com.company.project_Primak.src.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestPair {

    public void main() {
        ArrayList<String> dataTest;
        String inputType;
        do {
            System.out.print("Choose the way you want to input data for test (console/file): ");
            Scanner scInputType = new Scanner(System.in);
            inputType = scInputType.next();
            if (inputType.equals("console")) {
                dataTest = inputPairConsole();
                testPairConsole(Integer.parseInt(dataTest.get(0)), Double.parseDouble(dataTest.get(1)));
                testGetFirstConsole(new Pair<>(Integer.parseInt(dataTest.get(0)),
                        Double.parseDouble(dataTest.get(1))));
                testGetSecondConsole(new Pair<>(Integer.parseInt(dataTest.get(0)),
                        Double.parseDouble(dataTest.get(1))));
                break;
            } else if (inputType.equals("file")) {
                System.out.print("Input filename to read data (with file extension): ");
                Scanner scFileRead = new Scanner(System.in);
                String fileRead = scFileRead.next();
                System.out.print("Input filename to write result (with file extension): ");
                Scanner scFileWrite = new Scanner(System.in);
                String fileWrite = scFileWrite.next();
                dataTest = inputPairFile(fileRead);
                testPairFile(Integer.parseInt(dataTest.get(0)), Double.parseDouble(dataTest.get(1)), fileWrite);
                testGetFirstFile(new Pair<>(Integer.parseInt(dataTest.get(0)),
                        Double.parseDouble(dataTest.get(1))), fileWrite);
                testGetSecondFile(new Pair<>(Integer.parseInt(dataTest.get(0)),
                        Double.parseDouble(dataTest.get(1))), fileWrite);
                break;
            }
        } while (true);
    }

    public ArrayList<String> inputPairConsole() {
        ArrayList<String> input = new ArrayList<>();
        System.out.print("Input int number: ");
        Scanner scIntNum = new Scanner(System.in);
        String intNum = scIntNum.next();
        input.add(intNum);
        System.out.print("Input double number: ");
        Scanner scDoubleNum = new Scanner(System.in);
        String doubleNum = scDoubleNum.next();
        input.add(doubleNum);
        return input;
    }

    public ArrayList<String> inputPairFile(String fileRead) {
        ArrayList<String> input = new ArrayList<>();
        try {
            FileReader fr = new FileReader(Csv.filePath+fileRead);
            BufferedReader br = new BufferedReader(fr);
            String intNum = br.readLine();
            input.add(intNum);
            String doubleNum = br.readLine();
            input.add(doubleNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public void testPairConsole(int intNum, double doubleNum) {
        System.out.println("===Test Pair constructor===");
        new Pair<>(intNum, doubleNum);
        System.out.println("=======Test complete=======\n");
    }

    public void testPairFile(int intNum, double doubleNum, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath+fileWrite);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Pair constructor===");
            new Pair<>(intNum, doubleNum);
            pw.println("=======Test complete=======\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetFirstConsole(Pair<Integer, Double> pair) {
        System.out.println("===Test Pair method 'getFirst'===");
        System.out.println(pair.getFirst());
        System.out.println("===========Test complete==========\n");
    }

    public void testGetFirstFile(Pair<Integer, Double> pair, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath+fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Pair method 'getFirst'===");
            pw.println(pair.getFirst());
            pw.println("===========Test complete==========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetSecondConsole(Pair<Integer, Double> pair) {
        System.out.println("===Test Pair method 'getSecond'===");
        System.out.println(pair.getSecond());
        System.out.println("===========Test complete==========\n");
    }

    public void testGetSecondFile(Pair<Integer, Double> pair, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath+fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Pair method 'getSecond'===");
            pw.println(pair.getSecond());
            pw.println("===========Test complete==========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.company.project_Primak.test;

import com.company.project_Primak.src.Csv;
import com.company.project_Primak.src.Pair;
import com.company.project_Primak.src.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestCsv {
    public void main() throws FileNotFoundException {
        Pair<ArrayList<String>, ArrayList<Student>> dataTest;
        String inputType;
        do {
            System.out.print("Choose the way you want to input data for test (console/file): ");
            Scanner scInputType = new Scanner(System.in);
            inputType = scInputType.next();
            if (inputType.equals("console")) {
                dataTest = inputCsvConsole();
                testReadCsvConsole(dataTest.getFirst().get(0));
                testWriteCsvConsole(dataTest.getFirst().get(1), dataTest.getSecond());
                break;
            } else if (inputType.equals("file")) {
                System.out.print("Input filename to read data (with file extension): ");
                Scanner scFileRead = new Scanner(System.in);
                String fileRead = scFileRead.next();
                System.out.print("Input filename to write result (with file extension): ");
                Scanner scFileWrite = new Scanner(System.in);
                String fileWrite = scFileWrite.next();
                dataTest = inputCsvFile(fileRead);
                testReadCsvFile(dataTest.getFirst().get(0), fileWrite);
                testWriteCsvFile(dataTest.getFirst().get(1), fileWrite, dataTest.getSecond());
                break;
            }
        } while (true);
    }

    public Pair<ArrayList<String>, ArrayList<Student>> inputCsvConsole() {
        ArrayList<String> inputString = new ArrayList<>();
        ArrayList<Student> inputStudent = new ArrayList<>();
        System.out.print("Input filename to read data: ");
        Scanner scFileRead = new Scanner(System.in);
        String fileRead = scFileRead.next();
        inputString.add(fileRead);
        System.out.print("Input filename to write data: ");
        Scanner scFileWrite = new Scanner(System.in);
        String fileWrite = scFileWrite.next();
        inputString.add(fileWrite);
        System.out.print("Input the number of students: ");
        Scanner scN = new Scanner(System.in);
        int n = scN.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Input last middle first name of student: ");
            Scanner scLmfName = new Scanner(System.in);
            String lmfName = scLmfName.nextLine();
            System.out.print("Input the group of student: ");
            Scanner scGroup = new Scanner(System.in);
            String group = scGroup.nextLine();
            System.out.print("Input the course of student: ");
            Scanner scCourse = new Scanner(System.in);
            String course = scCourse.nextLine();
            System.out.print("Input the number of subjects: ");
            Scanner scM = new Scanner(System.in);
            int m = scM.nextInt();
            ArrayList<String> subjects = new ArrayList<>();
            ArrayList<String> teachers = new ArrayList<>();
            ArrayList<Integer> marks = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                System.out.print("Input subject " + (j + 1) + ": ");
                Scanner scSubject = new Scanner(System.in);
                String subject = scSubject.next();
                subjects.add(subject);
                System.out.print("Input teacher " + (j + 1) + ": ");
                Scanner scTeacher = new Scanner(System.in);
                String teacher = scTeacher.next();
                teachers.add(teacher);
                System.out.print("Input mark " + (j + 1) + ": ");
                Scanner scMark = new Scanner(System.in);
                int mark = scMark.nextInt();
                marks.add(mark);
            }
            inputStudent.add(new Student(lmfName, group, course, subjects, teachers, marks));
        }
        return new Pair<>(inputString, inputStudent);
    }

    public Pair<ArrayList<String>, ArrayList<Student>> inputCsvFile(String fileName) {
        ArrayList<String> inputString = new ArrayList<>();
        ArrayList<Student> inputStudent = new ArrayList<>();
        try {
            FileReader fr = new FileReader(Csv.filePath+fileName);
            BufferedReader br = new BufferedReader(fr);
            String fileRead = null;
            String fileWrite = null;
            String line;
            int countLine = 1;
            while((line = br.readLine()) != null) {
                if (countLine == 1) {
                    fileRead = line;
                } else if (countLine == 2) {
                    fileWrite = line;
                } else {
                    String[] row = line.split(",");
                    String lmfName;
                    String group;
                    String course;
                    ArrayList<String> subjects = new ArrayList<>();
                    ArrayList<String> teachers = new ArrayList<>();
                    ArrayList<Integer> marks = new ArrayList<>();
                    lmfName = row[0];
                    group = row[1];
                    course = row[2];
                    int curSize = (row.length - 3) / 3;
                    for (int i = 0; i < curSize; i++) {
                        subjects.add(row[2 + 3 * i + 1]);
                        teachers.add(row[2 + 3 * i + 2]);
                        marks.add(Integer.parseInt(row[2 + 3 * i + 3]));
                    }
                    inputStudent.add(new Student(lmfName, group, course, subjects, teachers, marks));
                }
                countLine++;
            }
            inputString.add(fileRead);
            inputString.add(fileWrite);
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return new Pair<>(inputString, inputStudent);
    }

    public void testReadCsvConsole(String fileName) throws FileNotFoundException {
        System.out.println("===Test Csv method 'readCsv'===");
        System.out.println(Csv.readCsv(fileName));
        System.out.println("=========Test complete=========\n");
    }

    public void testReadCsvFile(String fileRead, String fileWrite) throws FileNotFoundException {
        try {
            FileWriter fw = new FileWriter(Csv.filePath+fileWrite);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Csv method 'readCsv'===");
            pw.println(Csv.readCsv(fileRead));
            pw.println("=========Test complete=========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testWriteCsvConsole(String fileName, ArrayList<Student> students) throws FileNotFoundException {
        System.out.println("===Test Csv method 'writeCsv'==");
        Csv.writeCsv(fileName, students);
        System.out.println("=========Test complete=========\n");
    }

    public void testWriteCsvFile(String fileName, String fileWrite, ArrayList<Student> students)
            throws FileNotFoundException {
        try {
            FileWriter fw = new FileWriter(Csv.filePath+fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Csv method 'writeCsv'==");
            Csv.writeCsv(fileName, students);
            pw.println("=========Test complete=========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.company.project_Primak.test;

import com.company.project_Primak.src.Csv;
import com.company.project_Primak.src.Pair;
import com.company.project_Primak.src.Sql;
import com.company.project_Primak.src.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestSql {
    public void main() throws FileNotFoundException {
        Pair<ArrayList<String>, ArrayList<Student>> dataTest;
        String inputType;
        do {
            System.out.print("Choose the way you want to input data for test (console/file): ");
            Scanner scInputType = new Scanner(System.in);
            inputType = scInputType.next();
            if (inputType.equals("console")) {
                dataTest = inputSqlConsole();
                testReadSqlConsole(
                        dataTest.getFirst().get(0),
                        dataTest.getFirst().get(1),
                        dataTest.getFirst().get(2),
                        dataTest.getFirst().get(3));
                testWriteSqlConsole(
                        dataTest.getFirst().get(0),
                        dataTest.getFirst().get(1),
                        dataTest.getFirst().get(2),
                        dataTest.getFirst().get(4),
                        dataTest.getSecond());
                testCreateInsertRowConsole(Integer.parseInt(dataTest.getFirst().get(5)));
                testCreateCreateRowConsole(Integer.parseInt(dataTest.getFirst().get(5)));
                break;
            } else if (inputType.equals("file")) {
                System.out.print("Input filename to read data (with file extension): ");
                Scanner scFileRead = new Scanner(System.in);
                String fileRead = scFileRead.next();
                System.out.print("Input filename to write result (with file extension): ");
                Scanner scFileName = new Scanner(System.in);
                String fileName = scFileName.next();
                dataTest = inputSqlFile(fileRead);
                testReadSqlFile(
                        dataTest.getFirst().get(0),
                        dataTest.getFirst().get(1),
                        dataTest.getFirst().get(2),
                        dataTest.getFirst().get(3),
                        fileName);
                testWriteSqlFile(
                        dataTest.getFirst().get(0),
                        dataTest.getFirst().get(1),
                        dataTest.getFirst().get(2),
                        dataTest.getFirst().get(4),
                        fileName,
                        dataTest.getSecond());
                testCreateInsertRowFile(Integer.parseInt(dataTest.getFirst().get(5)), fileName);
                testCreateCreateRowFile(Integer.parseInt(dataTest.getFirst().get(5)), fileName);
                break;
            }
        } while (true);
    }

    public Pair<ArrayList<String>, ArrayList<Student>> inputSqlConsole() {
        ArrayList<String> inputString = new ArrayList<>();
        ArrayList<Student> inputStudent = new ArrayList<>();
        System.out.print("Input username: ");
        Scanner scUser = new Scanner(System.in);
        String user = scUser.next();
        inputString.add(user);
        System.out.print("Input catalog: ");
        Scanner scCatalog = new Scanner(System.in);
        String catalog = scCatalog.next();
        inputString.add(catalog);
        System.out.print("Input schema: ");
        Scanner scSchema = new Scanner(System.in);
        String schema = scSchema.next();
        inputString.add(schema);
        System.out.print("Input table to read: ");
        Scanner scTableRead = new Scanner(System.in);
        String tableRead = scTableRead.next();
        inputString.add(tableRead);
        System.out.print("Input table to write: ");
        Scanner scTableWrite = new Scanner(System.in);
        String tableWrite = scTableWrite.next();
        inputString.add(tableWrite);
        System.out.print("Input subjects number: ");
        Scanner scColNum = new Scanner(System.in);
        String size = scColNum.next();
        inputString.add(size);
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

    public Pair<ArrayList<String>, ArrayList<Student>> inputSqlFile(String fileName) {
        ArrayList<String> inputString = new ArrayList<>();
        ArrayList<Student> inputStudent = new ArrayList<>();
        try {
            FileReader fr = new FileReader(Csv.filePath + fileName);
            BufferedReader br = new BufferedReader(fr);
            String user = null;
            String catalog = null;
            String schema = null;
            String tableRead = null;
            String tableWrite = null;
            String size = null;
            String line;
            int countLine = 1;
            while ((line = br.readLine()) != null) {
                if (countLine == 1) {
                    user = line;
                } else if (countLine == 2) {
                    catalog = line;
                } else if (countLine == 3) {
                    schema = line;
                } else if (countLine == 4) {
                    tableRead = line;
                } else if (countLine == 5) {
                    tableWrite = line;
                } else if (countLine == 6) {
                    size = line;
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
            inputString.add(user);
            inputString.add(catalog);
            inputString.add(schema);
            inputString.add(tableRead);
            inputString.add(tableWrite);
            inputString.add(size);
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return new Pair<>(inputString, inputStudent);
    }

    public void testReadSqlConsole(String user,
                                   String catalog,
                                   String schema,
                                   String table) {
        System.out.println("===Test Sql method 'readSql'===");
        System.out.println(Sql.readSql(user, catalog, schema, table));
        System.out.println("=========Test complete=========\n");
    }

    public void testReadSqlFile(String user,
                                String catalog,
                                String schema,
                                String table,
                                String fileName) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileName);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Sql method 'readSql'===");
            pw.println(Sql.readSql(user, catalog, schema, table));
            pw.println("=========Test complete=========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testWriteSqlConsole(String user,
                                    String catalog,
                                    String schema,
                                    String table,
                                    ArrayList<Student> students) {
        System.out.println("===Test Sql method 'writeSql'==");
        Sql.writeSql(user, catalog, schema, table, students);
        System.out.println("=========Test complete=========\n");
    }

    public void testWriteSqlFile(String user,
                                 String catalog,
                                 String schema,
                                 String table,
                                 String fileName,
                                 ArrayList<Student> students) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath+fileName, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Sql method 'writeSql'==");
            Sql.writeSql(user, catalog, schema, table, students);
            pw.println("=========Test complete=========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testCreateInsertRowConsole(int size) {
        System.out.println("===Test Sql method 'createInsertRow'==");
        System.out.println(Sql.createInsertRow(size));
        System.out.println("=========Test complete=========\n");
    }

    public void testCreateInsertRowFile(int size, String fileName) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath+fileName, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Sql method 'createInsertRow'==");
            pw.println(Sql.createInsertRow(size));
            pw.println("=========Test complete=========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testCreateCreateRowConsole(int size) {
        System.out.println("===Test Sql method 'createCreateRow'==");
        System.out.println(Sql.createCreateRow(size));
        System.out.println("=========Test complete=========\n");
    }

    public void testCreateCreateRowFile(int size, String fileName) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath+fileName, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Sql method 'createCreateRow'==");
            pw.println(Sql.createCreateRow(size));
            pw.println("=========Test complete=========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

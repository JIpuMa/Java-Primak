package com.company.project_Primak.src;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Csv {

    public static final String filePath = "C:\\Users\\Ярослав\\Desktop\\Python\\" +
            "Semester 5\\Java_Course\\src\\com\\company\\project_Primak\\resources\\";

    public static ArrayList<Student> readCsv(String fileName) throws FileNotFoundException {
        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(new File(filePath + fileName));
        while (input.hasNextLine()) {
            String lmfName;
            String group;
            String course;
            ArrayList<String> subjects = new ArrayList<>();
            ArrayList<String> teachers = new ArrayList<>();
            ArrayList<Integer> marks = new ArrayList<>();
            String line = input.nextLine();
            String[] row = line.split(",");
            lmfName = row[0];
            group = row[1];
            course = row[2];
            int curSize = (row.length - 3) / 3;
            for (int i = 0; i < curSize; i++) {
                subjects.add(row[2 + 3 * i + 1]);
                teachers.add(row[2 + 3 * i + 2]);
                marks.add(Integer.parseInt(row[2 + 3 * i + 3]));
            }
            students.add(new Student(lmfName, group, course, subjects, teachers, marks));
        }
        return students;
    }

    public static void writeCsv(String fileName, ArrayList<Student> students) throws FileNotFoundException {
        File csvFile = new File(filePath + fileName);
        PrintWriter output = new PrintWriter(csvFile);
        for (Student student : students) {

            output.printf("%s, %s, %s, %s\n",
                    student.getLmfName(),
                    student.getGroup(),
                    student.getCourse(),
                    student.convertAchievementsToTable(
                            Estimation.getMaxSubjects(students),
                            student.getSubjects(),
                            student.getTeachers(),
                            student.getMarks()));
        }
        output.close();
    }
}

package com.company.project_Primak.test;

import com.company.project_Primak.src.Csv;
import com.company.project_Primak.src.Estimation;
import com.company.project_Primak.src.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestStudent {
    public void main() {
        ArrayList<Student> dataTest;
        String inputType;
        do {
            System.out.print("Choose the way you want to input data for test (console/file): ");
            Scanner scInputType = new Scanner(System.in);
            inputType = scInputType.next();
            if (inputType.equals("console")) {
                dataTest = inputStudentConsole();
                Student stud1 = dataTest.get(0);
                Student stud2 = dataTest.get(1);
                testSetStudentConsole(
                        stud1.getLmfName(),
                        stud1.getGroup(),
                        stud1.getCourse(),
                        stud1.getSubjects(),
                        stud1.getTeachers(),
                        stud1.getMarks());
                testGetStudentConsole(stud1);
                testSetLmfNameConsole(stud1, stud2.getLmfName());
                testGetLmfNameConsole(stud1);
                testSetGroupConsole(stud1, stud2.getGroup());
                testGetGroupConsole(stud1);
                testSetCourseConsole(stud1, stud2.getCourse());
                testGetCourseConsole(stud1);
                testSetSubjectsConsole(stud1, stud2.getSubjects());
                testGetSubjectsConsole(stud1);
                testSetTeachersConsole(stud1, stud2.getTeachers());
                testGetTeachersConsole(stud1);
                testSetMarksConsole(stud1, stud2.getMarks());
                testGetMarksConsole(stud1);
                testToStringConsole(stud1);
                testConvertAchievementsToConsoleConsole(stud1,
                        stud1.getSubjects(),
                        stud1.getTeachers(),
                        stud1.getMarks());
                testConvertAchievementsToTableConsole(stud1,
                        Estimation.getMaxSubjects(dataTest),
                        stud1.getSubjects(),
                        stud1.getTeachers(),
                        stud1.getMarks());
                break;
            } else if (inputType.equals("file")) {
                System.out.print("Input filename to read data (with file extension): ");
                Scanner scFileRead = new Scanner(System.in);
                String fileRead = scFileRead.next();
                System.out.print("Input filename to write result (with file extension): ");
                Scanner scFileWrite = new Scanner(System.in);
                String fileWrite = scFileWrite.next();
                dataTest = inputStudentFile(fileRead);
                Student stud1 = dataTest.get(0);
                Student stud2 = dataTest.get(1);
                testSetStudentFile(
                        stud1.getLmfName(),
                        stud1.getGroup(),
                        stud1.getCourse(),
                        stud1.getSubjects(),
                        stud1.getTeachers(),
                        stud1.getMarks(),
                        fileWrite);
                testGetStudentFile(stud1, fileWrite);
                testSetLmfNameFile(stud1, stud2.getLmfName(), fileWrite);
                testGetLmfNameFile(stud1, fileWrite);
                testSetGroupFile(stud1, stud2.getGroup(), fileWrite);
                testGetGroupFile(stud1, fileWrite);
                testSetCourseFile(stud1, stud2.getCourse(), fileWrite);
                testGetCourseFile(stud1, fileWrite);
                testSetSubjectsFile(stud1, stud2.getSubjects(), fileWrite);
                testGetSubjectsFile(stud1, fileWrite);
                testSetTeachersFile(stud1, stud2.getTeachers(), fileWrite);
                testGetTeachersFile(stud1, fileWrite);
                testSetMarksFile(stud1, stud2.getMarks(), fileWrite);
                testGetMarksFile(stud1, fileWrite);
                testToStringFile(stud1, fileWrite);
                testConvertAchievementsToConsoleFile(stud1,
                        stud1.getSubjects(),
                        stud1.getTeachers(),
                        stud1.getMarks(),
                        fileWrite);
                testConvertAchievementsToTableFile(stud1,
                        Estimation.getMaxSubjects(dataTest),
                        stud1.getSubjects(),
                        stud1.getTeachers(),
                        stud1.getMarks(),
                        fileWrite);
                break;
            }
        } while (true);
    }

    public ArrayList<Student> inputStudentConsole() {
        ArrayList<Student> input = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
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
            input.add(new Student(lmfName, group, course, subjects, teachers, marks));
        }
        return input;
    }

    public ArrayList<Student> inputStudentFile(String fileName) {
        ArrayList<Student> input = new ArrayList<>();
        try {
            FileReader fr = new FileReader(Csv.filePath + fileName);
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < 2; i++) {
                String[] row = br.readLine().split(",");
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
                for (int j = 0; j < curSize; j++) {
                    subjects.add(row[2 + 3 * j + 1]);
                    teachers.add(row[2 + 3 * j + 2]);
                    marks.add(Integer.parseInt(row[2 + 3 * j + 3]));
                }
                input.add(new Student(lmfName, group, course, subjects, teachers, marks));
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return input;
    }

    public void testSetStudentConsole(String lmfName,
                                      String group,
                                      String course,
                                      ArrayList<String> subjects,
                                      ArrayList<String> teachers,
                                      ArrayList<Integer> marks) {
        System.out.println("===Test Student constructor and method 'setStudent'===");
        new Student(lmfName, group, course, subjects, teachers, marks);
        System.out.println("=====================Test complete====================\n");
    }

    public void testSetStudentFile(String lmfName,
                                   String group,
                                   String course,
                                   ArrayList<String> subjects,
                                   ArrayList<String> teachers,
                                   ArrayList<Integer> marks,
                                   String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student constructor and method 'setStudent'===");
            new Student(lmfName, group, course, subjects, teachers, marks);
            pw.println("=====================Test complete====================\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetStudentConsole(Student student) {
        System.out.println("===Test Student method 'getStudent'===");
        System.out.println(student.getStudent());
        System.out.println("=============Test complete============\n");
    }

    public void testGetStudentFile(Student student, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'getStudent'===");
            pw.println(student.getStudent());
            pw.println("=============Test complete============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSetLmfNameConsole(Student student, String lmfName) {
        System.out.println("===Test Student method 'setLmfName'===");
        student.setLmfName(lmfName);
        System.out.println("=============Test complete============\n");
    }

    public void testSetLmfNameFile(Student student, String lmfName, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'setLmfName'===");
            student.setLmfName(lmfName);
            pw.println("=============Test complete============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetLmfNameConsole(Student student) {
        System.out.println("===Test Student method 'getLmfName'===");
        System.out.println(student.getLmfName());
        System.out.println("=============Test complete============\n");
    }

    public void testGetLmfNameFile(Student student, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'getLmfName'===");
            pw.println(student.getLmfName());
            pw.println("=============Test complete============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSetGroupConsole(Student student, String group) {
        System.out.println("===Test Student method 'setGroup'===");
        student.setGroup(group);
        System.out.println("============Test complete===========\n");
    }

    public void testSetGroupFile(Student student, String group, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'setGroup'===");
            student.setGroup(group);
            pw.println("============Test complete===========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetGroupConsole(Student student) {
        System.out.println("===Test Student method 'getGroup'===");
        System.out.println(student.getGroup());
        System.out.println("============Test complete===========\n");
    }

    public void testGetGroupFile(Student student, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'getGroup'===");
            pw.println(student.getGroup());
            pw.println("============Test complete===========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSetCourseConsole(Student student, String course) {
        System.out.println("===Test Student method 'setCourse'===");
        student.setCourse(course);
        System.out.println("=============Test complete===========\n");
    }

    public void testSetCourseFile(Student student, String course, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'setCourse'===");
            student.setCourse(course);
            pw.println("=============Test complete===========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetCourseConsole(Student student) {
        System.out.println("===Test Student method 'getCourse'===");
        System.out.println(student.getCourse());
        System.out.println("============Test complete============\n");
    }

    public void testGetCourseFile(Student student, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'getCourse'===");
            pw.println(student.getCourse());
            pw.println("============Test complete============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSetSubjectsConsole(Student student, ArrayList<String> subjects) {
        System.out.println("===Test Student method 'setSubjects'===");
        student.setSubjects(subjects);
        System.out.println("==============Test complete============\n");
    }

    public void testSetSubjectsFile(Student student, ArrayList<String> subjects, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'setSubjects'===");
            student.setSubjects(subjects);
            pw.println("==============Test complete============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetSubjectsConsole(Student student) {
        System.out.println("===Test Student method 'getSubjects'===");
        System.out.println(student.getSubjects());
        System.out.println("=============Test complete=============\n");
    }

    public void testGetSubjectsFile(Student student, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'getSubjects'===");
            pw.println(student.getSubjects());
            pw.println("=============Test complete=============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSetTeachersConsole(Student student, ArrayList<String> teachers) {
        System.out.println("===Test Student method 'setTeachers'===");
        student.setSubjects(teachers);
        System.out.println("==============Test complete============\n");
    }

    public void testSetTeachersFile(Student student, ArrayList<String> teachers, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'setTeachers'===");
            student.setTeachers(teachers);
            pw.println("==============Test complete============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetTeachersConsole(Student student) {
        System.out.println("===Test Student method 'getTeachers'===");
        System.out.println(student.getTeachers());
        System.out.println("=============Test complete=============\n");
    }

    public void testGetTeachersFile(Student student, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'getTeachers'===");
            pw.println(student.getTeachers());
            pw.println("=============Test complete=============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSetMarksConsole(Student student, ArrayList<Integer> marks) {
        System.out.println("===Test Student method 'setMarks'===");
        student.setMarks(marks);
        System.out.println("============Test complete===========\n");
    }

    public void testSetMarksFile(Student student, ArrayList<Integer> marks, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'setMarks'===");
            student.setMarks(marks);
            pw.println("============Test complete===========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetMarksConsole(Student student) {
        System.out.println("===Test Student method 'getMarks'===");
        System.out.println(student.getMarks());
        System.out.println("============Test complete===========\n");
    }

    public void testGetMarksFile(Student student, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'getMarks'===");
            pw.println(student.getMarks());
            pw.println("============Test complete===========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testToStringConsole(Student student) {
        System.out.println("===Test Student method 'toString'===");
        System.out.println(student.toString());
        System.out.println("=============Test complete===========\n");
    }

    public void testToStringFile(Student student, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'toString'===");
            pw.println(student.toString());
            pw.println("=============Test complete===========\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testConvertAchievementsToConsoleConsole(Student student,
                                                        ArrayList<String> subjects,
                                                        ArrayList<String> teachers,
                                                        ArrayList<Integer> marks) {
        System.out.println("===Test Student method 'convertAchievementsToConsole'===");
        System.out.println(student.convertAchievementsToConsole(subjects, teachers, marks));
        System.out.println("======================Test complete=====================\n");
    }

    public void testConvertAchievementsToConsoleFile(Student student,
                                                     ArrayList<String> subjects,
                                                     ArrayList<String> teachers,
                                                     ArrayList<Integer> marks,
                                                     String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'convertAchievementsToConsole'===");
            pw.println(student.convertAchievementsToConsole(subjects, teachers, marks));
            pw.println("======================Test complete=====================\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testConvertAchievementsToTableConsole(Student student,
                                                      int size,
                                                      ArrayList<String> subjects,
                                                      ArrayList<String> teachers,
                                                      ArrayList<Integer> marks) {
        System.out.println("===Test Student method 'convertAchievementsToTable'===");
        System.out.println(student.convertAchievementsToTable(size, subjects, teachers, marks));
        System.out.println("=====================Test complete====================\n");
    }

    public void testConvertAchievementsToTableFile(Student student,
                                                   int size,
                                                   ArrayList<String> subjects,
                                                   ArrayList<String> teachers,
                                                   ArrayList<Integer> marks,
                                                   String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Student method 'convertAchievementsToTable'===");
            pw.println(student.convertAchievementsToTable(size, subjects, teachers, marks));
            pw.println("=====================Test complete====================\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

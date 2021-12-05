package com.company.project_Primak.test;

import com.company.project_Primak.src.Csv;
import com.company.project_Primak.src.Estimation;
import com.company.project_Primak.src.Pair;
import com.company.project_Primak.src.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestEstimation {
    public void main() {
        ArrayList<Student> dataTest;
        String inputType;
        do {
            System.out.print("Choose the way you want to input data for test (console/file): ");
            Scanner scInputType = new Scanner(System.in);
            inputType = scInputType.next();
            if (inputType.equals("console")) {
                dataTest = inputEstimationConsole();
                Estimation estimation = new Estimation();
                testSetStudentsConsole(estimation, dataTest);
                testGetStudentsConsole(estimation);
                testEstimateByStudentConsole(estimation, dataTest.get(0).getLmfName());
                testEstimateByGroupConsole(estimation, dataTest.get(0).getGroup());
                testEstimateByCourseConsole(estimation, dataTest.get(0).getCourse());
                testEstimateByTeacherConsole(estimation, dataTest.get(0).getTeachers().get(0));
                testGetMaxSubjectsConsole(dataTest);
                break;
            } else if (inputType.equals("file")) {
                System.out.print("Input filename to read data (with file extension): ");
                Scanner scFileRead = new Scanner(System.in);
                String fileRead = scFileRead.next();
                System.out.print("Input filename to write result (with file extension): ");
                Scanner scFileWrite = new Scanner(System.in);
                String fileWrite = scFileWrite.next();
                dataTest = inputEstimationFile(fileRead);
                Estimation estimation = new Estimation();
                testSetStudentsFile(estimation, dataTest, fileWrite);
                testGetStudentsFile(estimation, fileWrite);
                testEstimateByStudentFile(estimation, dataTest.get(0).getLmfName(), fileWrite);
                testEstimateByGroupFile(estimation, dataTest.get(0).getGroup(), fileWrite);
                testEstimateByCourseFile(estimation, dataTest.get(0).getCourse(), fileWrite);
                testEstimateByTeacherFile(estimation, dataTest.get(0).getTeachers().get(0), fileWrite);
                testGetMaxSubjectsFile(dataTest, fileWrite);
                break;
            }
        } while (true);
    }

    public ArrayList<Student> inputEstimationConsole() {
        ArrayList<Student> input = new ArrayList<>();
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
            input.add(new Student(lmfName, group, course, subjects, teachers, marks));
        }
        return input;
    }

    public ArrayList<Student> inputEstimationFile(String fileRead) {
        ArrayList<Student> input = new ArrayList<>();
        try {
            FileReader fr = new FileReader(Csv.filePath + fileRead);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
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
                input.add(new Student(lmfName, group, course, subjects, teachers, marks));

            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return input;
    }

    public void testSetStudentsConsole(Estimation estimation, ArrayList<Student> students) {
        System.out.println("===Test Estimation method 'setStudents'===");
        estimation.setStudents(students);
        System.out.println("===============Test complete==============\n");
    }

    public void testSetStudentsFile(Estimation estimation, ArrayList<Student> students, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'setStudents'===");
            estimation.setStudents(students);
            pw.println("===============Test complete==============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetStudentsConsole(Estimation estimation) {
        System.out.println("===Test Estimation method 'getStudents'===");
        System.out.println(estimation.getStudents());
        System.out.println("===============Test complete==============\n");
    }

    public void testGetStudentsFile(Estimation estimation, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'getStudents'===");
            pw.println(estimation.getStudents());
            pw.println("===============Test complete==============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testEstimateByStudentConsole(Estimation estimation, String lmfName) {
        System.out.println("===Test Estimation method 'estimateByStudent'===");
        System.out.println("=====Test Estimation method 'calcByStudent'=====");
        System.out.println("=====Test Estimation method 'showByStudent'=====");
        Pair<Double, String> estByStudent = estimation.estimateByStudent(lmfName);
        System.out.println(estByStudent.getFirst());
        System.out.println(estByStudent.getSecond());
        System.out.println("==================Test complete=================\n");
    }

    public void testEstimateByStudentFile(Estimation estimation, String lmfName, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'estimateByStudent'===");
            pw.println("=====Test Estimation method 'calcByStudent'=====");
            pw.println("=====Test Estimation method 'showByStudent'=====");
            Pair<Double, String> estByStudent = estimation.estimateByStudent(lmfName);
            pw.println(estByStudent.getFirst());
            pw.println(estByStudent.getSecond());
            pw.println("==================Test complete=================\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testEstimateByGroupConsole(Estimation estimation, String group) {
        System.out.println("===Test Estimation method 'estimateByGroup'===");
        System.out.println("=====Test Estimation method 'calcByGroup'=====");
        System.out.println("=====Test Estimation method 'showByGroup'=====");
        Pair<Double, String> estByGroup = estimation.estimateByGroup(group);
        System.out.println(estByGroup.getFirst());
        System.out.println(estByGroup.getSecond());
        System.out.println("==================Test complete================\n");
    }

    public void testEstimateByGroupFile(Estimation estimation, String group, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("====Test Estimation method 'estimateByGroup'====");
            pw.println("===Test Estimation method 'calcByGroupCourse'===");
            pw.println("======Test Estimation method 'showByGroup'======");
            Pair<Double, String> estByGroup = estimation.estimateByGroup(group);
            pw.println(estByGroup.getFirst());
            pw.println(estByGroup.getSecond());
            pw.println("==================Test complete================\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testEstimateByCourseConsole(Estimation estimation, String course) {
        System.out.println("===Test Estimation method 'estimateByCourse'====");
        System.out.println("===Test Estimation method 'calcByGroupCourse'===");
        System.out.println("=====Test Estimation method 'showByCourse'======");
        Pair<Double, String> estByCourse = estimation.estimateByGroup(course);
        System.out.println(estByCourse.getFirst());
        System.out.println(estByCourse.getSecond());
        System.out.println("==================Test complete================\n");
    }

    public void testEstimateByCourseFile(Estimation estimation, String course, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'estimateByCourse'===");
            pw.println("=====Test Estimation method 'calcByCourse'=====");
            pw.println("=====Test Estimation method 'showByCourse'=====");
            Pair<Double, String> estByCourse = estimation.estimateByCourse(course);
            pw.println(estByCourse.getFirst());
            pw.println(estByCourse.getSecond());
            pw.println("==================Test complete================\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testEstimateByTeacherConsole(Estimation estimation, String teacher) {
        System.out.println("===Test Estimation method 'estimateByTeacher'===");
        System.out.println("=====Test Estimation method 'calcByTeacher'=====");
        System.out.println("=====Test Estimation method 'showByTeacher'=====");
        Pair<Double, String> estByTeacher = estimation.estimateByTeacher(teacher);
        System.out.println(estByTeacher.getFirst());
        System.out.println(estByTeacher.getSecond());
        System.out.println("==================Test complete=================\n");
    }

    public void testEstimateByTeacherFile(Estimation estimation, String teacher, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'estimateByTeacher'===");
            pw.println("=====Test Estimation method 'calcByTeacher'=====");
            pw.println("=====Test Estimation method 'showByTeacher'=====");
            Pair<Double, String> estByTeacher = estimation.estimateByTeacher(teacher);
            pw.println(estByTeacher.getFirst());
            pw.println(estByTeacher.getSecond());
            pw.println("==================Test complete=================\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testCalcByStudentConsole(Estimation estimation, Student student) {
        System.out.println("===Test Estimation method 'calcByStudent'===");
        System.out.println(estimation.calcByStudent(student));
        System.out.println("================Test complete===============\n");
    }

    public void testCalcByStudentFile(Estimation estimation, Student student, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'calcByStudent'===");
            pw.println(estimation.calcByStudent(student));
            pw.println("================Test complete===============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testCalcByGroupCourseConsole(Estimation estimation, ArrayList<Student> students) {
        System.out.println("===Test Estimation method 'calcByGroupCourse'===");
        System.out.println(estimation.calcByGroupCourse(students));
        System.out.println("==================Test complete=================\n");
    }

    public void testCalcByGroupCourseFile(Estimation estimation, ArrayList<Student> students, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'calcByGroupCourse'===");
            pw.println(estimation.calcByGroupCourse(students));
            pw.println("==================Test complete=================\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testCalcByTeacherConsole(Estimation estimation,
                                         ArrayList<Pair<Student, Integer>> students) {
        System.out.println("===Test Estimation method 'calcByTeacher'===");
        System.out.println(estimation.calcByTeacher(students));
        System.out.println("================Test complete===============\n");
    }

    public void testCalcByTeacherFile(Estimation estimation,
                                      ArrayList<Pair<Student, Integer>> studentsByTeacher,
                                      String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'calcByTeacher'===");
            pw.println(estimation.calcByTeacher(studentsByTeacher));
            pw.println("================Test complete===============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testShowByStudentConsole(Estimation estimation, Student student, double estimate) {
        System.out.println("===Test Estimation method 'showByStudent'===");
        System.out.println(estimation.showByStudent(student, estimate));
        System.out.println("================Test complete===============\n");
    }

    public void testShowByStudentFile(Estimation estimation, Student student, double estimate, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'showByStudent'===");
            pw.println(estimation.showByStudent(student, estimate));
            pw.println("================Test complete===============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testShowByGroupConsole(Estimation estimation,
                                         ArrayList<Student> students,
                                         double estimate) {
        System.out.println("===Test Estimation method 'showByGroup'===");
        System.out.println(estimation.showByGroup(students, estimate));
        System.out.println("===============Test complet===============\n");
    }

    public void testShowByGroupFile(Estimation estimation,
                                      ArrayList<Student> students,
                                      double estimate,
                                      String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'showByGroup'===");
            pw.println(estimation.showByGroup(students, estimate));
            pw.println("===============Test complete==============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testShowByCourseConsole(Estimation estimation,
                                             ArrayList<Student> students,
                                             double estimate) {
        System.out.println("===Test Estimation method 'showByCourse'===");
        System.out.println(estimation.showByCourse(students, estimate));
        System.out.println("===============Test complete===============\n");
    }

    public void testShowByCourseFile(Estimation estimation,
                                          ArrayList<Student> students,
                                          double estimate,
                                          String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'showByCourse'===");
            pw.println(estimation.showByCourse(students, estimate));
            pw.println("===============Test complete===============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testShowByTeacherConsole(Estimation estimation,
                                         ArrayList<Pair<Student, Integer>> students,
                                         double estimate,
                                         String teacher) {
        System.out.println("===Test Estimation method 'showByTeacher'===");
        System.out.println(estimation.showByTeacher(students, estimate, teacher));
        System.out.println("================Test complete===============\n");
    }

    public void testShowByTeacherFile(Estimation estimation,
                                      ArrayList<Pair<Student, Integer>> students,
                                      double estimate,
                                      String teacher,
                                      String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'showByTeacher'===");
            pw.println(estimation.showByTeacher(students, estimate, teacher));
            pw.println("================Test complete===============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetMaxSubjectsConsole(ArrayList<Student> students) {
        System.out.println("===Test Estimation method 'getMaxSubjects'===");
        System.out.println(Estimation.getMaxSubjects(students));
        System.out.println("=================Test complete===============\n");
    }

    public void testGetMaxSubjectsFile(ArrayList<Student> students, String fileWrite) {
        try {
            FileWriter fw = new FileWriter(Csv.filePath + fileWrite, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===Test Estimation method 'getMaxSubjects'===");
            pw.println(Estimation.getMaxSubjects(students));
            pw.println("=================Test complete===============\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.company.project_Primak.src;

import java.util.ArrayList;
import java.util.Objects;

public class Estimation {
    private ArrayList<Student> students;

    public Estimation() {}

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }


    public Pair<Double, String> estimateByStudent(String lmfName) {
        double studentEstimate = 0;
        String showStudent = "";
        for (Student student: this.students) {
            if (student.getLmfName().equals(lmfName)) {
                studentEstimate = calcByStudent(student);
                showStudent = showByStudent(student, studentEstimate);
                break;
            }
        }
        return new Pair<>(studentEstimate, showStudent);
    }

    public Pair<Double, String> estimateByGroup(String group) {
        double groupEstimate;
        String showGroup;
        ArrayList<Student> groupStudents = new ArrayList<>();
        for (Student student: this.students) {
            if (student.getGroup().equals(group)) {
                groupStudents.add(student);
            }
        }
        groupEstimate = calcByGroupCourse(groupStudents);
        showGroup = showByGroup(groupStudents, groupEstimate);
        return new Pair<>(groupEstimate, showGroup);
    }

    public Pair<Double, String> estimateByCourse(String course) {
        double courseEstimate;
        String showCourse;
        ArrayList<Student> courseStudents = new ArrayList<>();
        for (Student student: this.students) {
            if (student.getCourse().equals(course)) {
                courseStudents.add(student);
            }
        }
        courseEstimate = calcByGroupCourse(courseStudents);
        showCourse = showByCourse(courseStudents, courseEstimate);
        return new Pair<>(courseEstimate, showCourse);
    }

    public Pair<Double, String> estimateByTeacher(String teacher) {
        double byTeacherEstimate;
        String showByTeacher;
        ArrayList<Pair<Student, Integer>> teacherStudents = new ArrayList<>();
        for (Student student: this.students) {
            if (student.getTeachers().contains(teacher)) {
                teacherStudents.add(new Pair<Student, Integer>(student,
                        student.getTeachers().indexOf(teacher)));
            }
        }
        byTeacherEstimate = calcByTeacher(teacherStudents);
        showByTeacher = showByTeacher(teacherStudents, byTeacherEstimate, teacher);
        return new Pair<>(byTeacherEstimate, showByTeacher);
    }

    public double calcByStudent(Student student) {
        double sum = 0;
        ArrayList<Integer> marks = student.getMarks();
        for (int mark: marks) {
            sum += mark;
        }
        return sum / marks.size();
    }

    public double calcByGroupCourse(ArrayList<Student> students) {
        double sum = 0;
        for (Student student: students) {
            sum += calcByStudent(student);
        }
        return sum / students.size();
    }

    public double calcByTeacher(ArrayList<Pair<Student, Integer>> studentsByTeacher) {
        double sum = 0;
        for (Pair<Student, Integer> pair: studentsByTeacher) {
            sum += pair.first.getMarks().get(pair.second);
        }
        return sum / studentsByTeacher.size();
    }

    public String showByStudent(Student student, double estimate) {
        String header = "";
        String info = "";
        String gpa = "";
        header = String.format("%-20s %-20s %-10s",
                "Student name",
                "Group",
                "Course");
        info = String.format("%-20s %-20s %-10s",
                student.getLmfName(),
                student.getGroup(),
                student.getCourse());
        for (int i = 0; i < student.getSubjects().size(); i++) {
            header += String.format(" %-20s %-20s %-10s",
                    "Subject " + (i + 1),
                    "Teacher " + (i + 1),
                    "Mark " + (i + 1));
            info += String.format(" %-20s %-20s %-10s",
                    student.getSubjects().get(i),
                    student.getTeachers().get(i),
                    student.getMarks().get(i));
        }
        gpa = String.format("GPA = %.3f of %s;\n", estimate, student.getLmfName());
        return header + info + gpa;
    }

    public String showByGroup(ArrayList<Student> students, double estimate) {
        String header = "";
        String info = "";
        String gpa = "";
        header = String.format("%-20s %-20s %-10s %-10s",
                "Student name",
                "Group",
                "Course",
                "GPA");
        for (Student student: students) {
            info = String.format("%-20s %-20s %-10s %-10s",
                    student.getLmfName(),
                    student.getGroup(),
                    student.getCourse(),
                    calcByStudent(student));
        }
        if (!Objects.equals(students, new ArrayList<Student>())) {
            gpa = String.format("GPA = %.3f of %s group;\n", estimate, students.get(0).getGroup());
        }
        return header + info + gpa;
    }

    public String showByCourse(ArrayList<Student> students, double estimate) {
        String header = "";
        String info = "";
        String gpa = "";
        header = String.format("%-20s %-20s %-10s %-10s",
                "Student name",
                "Group",
                "Course",
                "GPA");
        for (Student student: students) {
            info = String.format("%-20s %-20s %-10s %-10s",
                    student.getLmfName(),
                    student.getGroup(),
                    student.getCourse(),
                    calcByStudent(student));
        }
        if (!Objects.equals(students, new ArrayList<Student>())) {
            gpa = String.format("GPA = %.3f of %s course;\n", estimate, students.get(0).getCourse());
        }
        return header + info + gpa;
    }

    public String showByTeacher(ArrayList<Pair<Student, Integer>> students, double estimate, String teacher) {
        String header = "";
        String info = "";
        String gpa = "";
        header = String.format("%-20s %-20s %-20s %-10s",
                "Student name",
                "Subject",
                "Teacher",
                "Mark");
        for (Pair<Student, Integer> pair: students) {
            info = String.format("%-20s %-20s %-20s %-10s",
                    pair.first.getLmfName(),
                    pair.first.getSubjects().get(pair.second),
                    pair.first.getTeachers().get(pair.second),
                    pair.first.getMarks().get(pair.second));
        }
        if (!Objects.equals(students, new ArrayList<Pair<Student, Integer>>())) {
            gpa = String.format("GPA = %.3f in relation to the %s;\n", estimate, teacher);
        }
        return header + info + gpa;
    }

    public static int getMaxSubjects(ArrayList<Student> students) {
        int max = Integer.MIN_VALUE;
        for (Student student: students) {
            if (student.getSubjects().size() > max) {
                max = student.getSubjects().size();
            }
        }
        return max;
    }
}

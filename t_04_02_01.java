package com.company.Cw;

import java.util.Scanner;

public class t_04_02_01 {
    public void main(String[] args) {
        String faculty = args[0];
        Student mas[] = new Student[10];
        for (int i = 0; i < 10; i++) {
            Scanner sc_id = new Scanner(System.in);
            int id = sc_id.nextInt();
            Scanner sc_pib = new Scanner(System.in);
            String pib = sc_pib.nextLine();
            Scanner sc_birthday = new Scanner(System.in);
            String birthday = sc_birthday.nextLine();
            Scanner sc_address = new Scanner(System.in);
            String address = sc_address.nextLine();
            Scanner sc_course = new Scanner(System.in);
            String course = sc_course.nextLine();
            Scanner sc_group = new Scanner(System.in);
            String group = sc_group.nextLine();
            mas[i].setStudent(id, pib, birthday, address, course, group);
        }
        getFacultyStuds(mas, faculty);
    }

    private void getFacultyStuds(Student[] st, String faculty) {
        for (Student s : st) {
            if (s.getFaculty() == faculty) {
                System.out.println(s);
            }
        }
    }
}

class Student {
    private int id;
    private String pib;
    private String address;
    private String birthday;
    private String course;
    private String group;

    public void setStudent(int id, String pib, String birthday,
                        String address, String course, String group) {
        this.id = id;
        this.pib = pib;
        this.address = address;
        this.birthday = birthday;
        this.course = course;
        this.group = group;
    }

    public void setStudent() {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
    }

    public Student getStudent() {
        return this;
    }

    public String getFaculty() {
        return group;
    }

    public Student() {}

    public Student(int id, String pib, String birthday,
                   String address, String course, String group) {
        setStudent(id, pib, birthday, address, course, group);
    }

    @Override
    public String toString() {
        return "Student: " + id + pib + address + birthday + course + group;
    }
}

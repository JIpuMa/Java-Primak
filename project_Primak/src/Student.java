package com.company.project_Primak.src;

import java.util.ArrayList;

public class Student {
    private String lmfName;
    private String group;
    private String course;
    private ArrayList<String> subjects;
    private ArrayList<String> teachers;
    private ArrayList<Integer> marks;

    public Student() {}

    public Student(String lmfName,
                   String group,
                   String course,
                   ArrayList<String> subjects,
                   ArrayList<String> teachers,
                   ArrayList<Integer> marks) {
        setStudent(lmfName, group, course, subjects, teachers, marks);
    }

    public void setStudent(String lmfName,
                           String group,
                           String course,
                           ArrayList<String> subjects,
                           ArrayList<String> teachers,
                           ArrayList<Integer> marks) {
        this.lmfName = lmfName;
        this.group = group;
        this.course = course;
        this.subjects = subjects;
        this.teachers = teachers;
        this.marks = marks;
    }

    public Student getStudent() {
        return this;
    }

    public void setLmfName(String lmfName) {
        this.lmfName = lmfName;
    }

    public String getLmfName() {
        return lmfName;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setTeachers(ArrayList<String> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<String> getTeachers() {
        return teachers;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return String.format("Student %s, group %s, course %s:\n%s",
                lmfName, group, course, convertAchievementsToConsole(subjects, teachers, marks));
    }

    public String convertAchievementsToConsole(ArrayList<String> subjects,
                                               ArrayList<String> teachers,
                                               ArrayList<Integer> marks) {
        String achievs = "";
        if ((subjects.size() == teachers.size()) & (teachers.size() == marks.size())) {
            for(int i = 0; i < subjects.size(); i++) {
                achievs += String.format("Subject %1$s: %2$-20s Teacher %1$s: %3$-35s Mark %1$s: %4$-3s;\n",
                        (i+1), subjects.get(i), teachers.get(i), marks.get(i));
            }
        }
        return achievs;
    }

    public String convertAchievementsToTable(int size,
                                             ArrayList<String> subjects,
                                             ArrayList<String> teachers,
                                             ArrayList<Integer> marks){
        String achievs = "";
        if ((subjects.size() == teachers.size()) & (teachers.size() == marks.size())) {
            for(int i = 0; i < size; i++) {
                if (i < subjects.size()){
                    achievs += String.format("%s,%s,%s",
                            subjects.get(i), teachers.get(i), marks.get(i));
                } else {
                    achievs += String.format(null + ", " + null + ", " + null);
                }
                if (i != size - 1) {
                    achievs += ",";
                }
            }
        }
        return achievs;
    }
}

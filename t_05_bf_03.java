package com.company.Cw;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class t_05_bf_03 {
    public void main() {
        Students[] students = {
                new Students("pib1", "1", "82", 2, new int[] {84, 59}),
                new Students("pib2", "3", "15", 3, new int[] {16, 46, 99}),
                new Students("pib3", "2", "2", 1, new int[] {80}),
                new Students("pib4", "1", "42", 2, new int[] {95, 71})
        };
        writeFile("stds.stds", students);
        students = readFile("stds.stds");
        System.out.println(Arrays.toString(students));

        Students std = new Students("pib5", "4", "53", 2, new int[] {55, 38});

        assert students != null;
        students = addStudent(students, std);
        System.out.println(Arrays.toString(students));

        searchByName("stds.stds", "std.std", "pib3");
        searchByMark("stds.stds");
    }

    public Students[] addStudent(Students[] students, Students student) {
        Students[] new_students = new Students[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            new_students[i] = students[i];
        }
        new_students[students.length] = student;
        return new_students;
    }

    public void searchByName(String file_read, String file_write, String name) {
        Students[] students = readFile(file_read);
        assert students != null;
        for (Students std: students) {
            if (name.equals(std.pib)) {
                writeFile(file_write, new Students[] {std});
            }
        }
    }

    public void searchByMark(String file_read) {
        Students[] students = readFile(file_read);
        assert students != null;
        double worst_mark = Double.MAX_VALUE;
        Students worst_std = null;
        for (Students std: students) {
            int[] marks = std.marks;
            double cur_mark = 0;
            for (int mark: marks) {
                cur_mark += mark;
            }
            cur_mark /= marks.length;
            if (cur_mark < worst_mark) {
                worst_mark = cur_mark;
                worst_std = std;
            }
        }
        System.out.println(worst_std);
    }

    public static void writeFile(String filename, Students[] std) {
        FileOutputStream fos;
        BufferedOutputStream bos;
        ObjectOutputStream oos;

        try {
            fos = new FileOutputStream(filename);
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);

            for (Students s: std)
                oos.writeObject(s);

            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Students[] readFile(String filename) {
        FileInputStream fis;
        BufferedInputStream bis;
        ObjectInputStream ois;

        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);

            ArrayList<Students> list = new ArrayList<>();
            try {
                while (true) {
                    list.add((Students) ois.readObject());
                }
            } catch (EOFException e) {
                ois.close();
                return list.toArray(new Students[0]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Students implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public String pib;
    public String course;
    public String gradebook;
    public int subjects_num;
    public int[] marks;

    Students(String pib, String course, String gradebook, int subjects_num, int[] marks) {
        this.pib = pib;
        this.course = course;
        this.gradebook = gradebook;
        this.subjects_num = subjects_num;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student: {" +
                "pib='" + pib + '\'' +
                ", course='" + course + '\'' +
                ", gradebook='" + gradebook + '\'' +
                ", subjects_num=" + subjects_num +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}

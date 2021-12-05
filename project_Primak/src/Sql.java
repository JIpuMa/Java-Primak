package com.company.project_Primak.src;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Sql {
    public static ArrayList<Student> readSql(String user,
                                             String catalog,
                                             String schema,
                                             String table) {
        ArrayList<Student> students = new ArrayList<>();
        Properties myProp = new Properties();
        myProp.put("user", user);
        Connection conn;
        try {
            Class.forName("com.vertica.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Could not find the JDBC driver class
            e.printStackTrace();
            return students;
        }
        try {
            conn = DriverManager.getConnection(
                    "jdbc:vertica://localhost:5433/docker", myProp);
            ResultSet columns = conn.getMetaData().getColumns(catalog, schema, table,
                    null);
            ArrayList<String> columnNames = new ArrayList<>();
            while (columns.next()) {
                String curName = columns.getString("COLUMN_NAME");
                columnNames.add(curName);
            }
            int size = (columnNames.size() - 3) / 3;
            Statement statement = conn.createStatement();
            ResultSet info = statement.executeQuery("SELECT * FROM " + schema + "." + table);
            while (info.next()) {
                String lmfName;
                String group;
                String course;
                ArrayList<String> subjects = new ArrayList<>();
                ArrayList<String> teachers = new ArrayList<>();
                ArrayList<Integer> marks = new ArrayList<>();
                lmfName = info.getString(columnNames.get(0));
                group = info.getString(columnNames.get(1));
                course = info.getString(columnNames.get(2));
                for (int i = 0; i < size; i++) {
                    String subject = info.getString(columnNames.get(2 + 3 * i + 1));
                    String teacher = info.getString(columnNames.get(2 + 3 * i + 2));
                    String mark = info.getString(columnNames.get(2 + 3 * i + 3));
                    if (!(subject == null | teacher == null | mark == null)) {
                        subjects.add(subject);
                        teachers.add(teacher);
                        marks.add(Integer.parseInt(mark));
                    }
                }
                students.add(new Student(lmfName, group, course, subjects, teachers, marks));
            }
            conn.close();
        } catch (SQLTransientConnectionException connException) {
            // There was a potentially temporary network error
            System.out.print("Network connection issue: " + connException.getMessage());
        } catch (SQLInvalidAuthorizationSpecException authException) {
            // Either the username or password was wrong
            System.out.print("Could not log into database: " + authException.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void writeSql(String user,
                                String catalog,
                                String schema,
                                String table,
                                ArrayList<Student> students) {
        Properties myProp = new Properties();
        myProp.put("user", user);
        Connection conn;
        try {
            Class.forName("com.vertica.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Could not find the JDBC driver class
            e.printStackTrace();
            return;
        }
        try {
            conn = DriverManager.getConnection(
                    "jdbc:vertica://localhost:5433/docker", myProp);
            int size = Estimation.getMaxSubjects(students);
            Statement statement = conn.createStatement();
            String query1 = "CREATE TABLE " + catalog + "." + schema + "." + table + " " +
                    createCreateRow(size);
            while (true) {
                try {
                    statement.executeUpdate(query1);
                    break;
                } catch (SQLSyntaxErrorException e) {
                    statement.executeUpdate("DROP TABLE " + catalog + "." + schema + "." + table);
                } catch (SQLException e) {
                    e.printStackTrace();
                    return;
                }
            }
            String query2 = "INSERT INTO " + catalog + "." + schema + "." + table + " " +
                    createInsertRow(size);
            for (Student student : students) {
                PreparedStatement preparedStatement = conn.prepareStatement(query2);
                preparedStatement.setString(1, student.getLmfName());
                preparedStatement.setString(2, student.getGroup());
                preparedStatement.setInt(3, Integer.parseInt(student.getCourse()));
                for (int i = 0; i < size; i++) {
                    if (i < student.getSubjects().size()) {
                        preparedStatement.setString((3 + 3 * i + 1), student.getSubjects().get(i));
                        preparedStatement.setString((3 + 3 * i + 2), student.getTeachers().get(i));
                        preparedStatement.setInt((3 + 3 * i + 3), student.getMarks().get(i));
                    } else {
                        preparedStatement.setNull((3 + 3 * i + 1), Types.VARCHAR);
                        preparedStatement.setNull((3 + 3 * i + 2), Types.VARCHAR);
                        preparedStatement.setNull((3 + 3 * i + 3), Types.INTEGER);
                    }
                }
                preparedStatement.executeUpdate();
            }
            conn.close();
        } catch (SQLTransientConnectionException connException) {
            // There was a potentially temporary network error
            System.out.print("Network connection issue: " + connException.getMessage());
        } catch (SQLInvalidAuthorizationSpecException authException) {
            // Either the username or password was wrong
            System.out.print("Could not log into database: " + authException.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String createInsertRow(int size) {
        String tableColums = "(";
        tableColums += "student_name, ";
        tableColums += "\"group\", ";
        tableColums += "course, ";
        for (int i = 0; i < size; i++) {
            tableColums += "subject_" + (i + 1) + ", ";
            tableColums += "teacher_" + (i + 1) + ", ";
            tableColums += "mark_" + (i + 1);
            if (i != size - 1) {
                tableColums += ", ";
            } else {
                tableColums += ")";
            }
        }
        String tableValues = "Values (";
        for (int i = 0; i < 3 * (size + 1); i++) {
            tableValues += "?";
            if (i != 3 * (size + 1) - 1) {
                tableValues += ", ";
            } else {
                tableValues += ")";
            }
        }
        return tableColums + " " + tableValues;
    }

    public static String createCreateRow(int size) {
        String tableHeader = "\n(\n";
        tableHeader += "\tstudent_name varchar(80),\n";
        tableHeader += "\t\"group\" varchar(80),\n";
        tableHeader += "\tcourse int,\n";
        for (int i = 0; i < size; i++) {
            tableHeader += "\tsubject_" + (i + 1) + " varchar(80),\n";
            tableHeader += "\tteacher_" + (i + 1) + " varchar(80),\n";
            tableHeader += "\tmark_" + (i + 1) + " int";
            if (i != size - 1) {
                tableHeader += ",\n";
            } else {
                tableHeader += "\n)";
            }
        }
        return tableHeader;
    }
}
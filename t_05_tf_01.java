package com.company.Cw;

import java.io.*;
import java.util.*;

public class t_05_tf_01 {
    public static final String filePath = "C:\\Users\\Ярослав\\Desktop\\Python\\" +
            "Semester 5\\Java_Course\\src\\com\\company\\Cw\\";

    public void main() throws IOException {
        System.out.print("Input file name: ");
        Scanner sc_fname = new Scanner(System.in);
        String file_name = sc_fname.next();
        String[] file = readFile(file_name);
        String answer = "";
        answer += "a): " + longestWord(file);
        answer += "\nb): " + numberWords(file);
        answer += "\nc):\n" + String.join("\n", spaceAndWordsFilter(file));
        answer += "\nd):\n" + String.join("\n", spaceFilter(file));
        answer += "\ne):\n" + String.join("\n", spaceCreater(file));
        writeFile("H.txt", answer);
    }

    public String[] readFile(String name) throws FileNotFoundException {
        ArrayList<String> rows = new ArrayList<>();
        FileReader fr = new FileReader(filePath + name);
        BufferedReader bf = new BufferedReader(fr);
        Scanner input = new Scanner(bf);
        while (input.hasNextLine()) {
            rows.add(input.nextLine());
        }
        input.close();
        return rows.toArray(new String[0]);
    }

    public void writeFile(String name, String text) throws IOException {
        FileWriter fw = new FileWriter(filePath + name);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.print(text);
        pw.close();
    }

    public String longestWord(String[] file) {
        String longest_word = null;
        int max_len = Integer.MIN_VALUE;
        for (String row : file) {
            StringTokenizer st = new StringTokenizer(row, "\s");
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                if (word.length() > max_len) {
                    longest_word = word;
                    max_len = word.length();
                }
            }
        }
        return longest_word;
    }

    public int numberWords(String[] file) {
        int number = 0;
        for (String row : file) {
            int row_words = new StringTokenizer(row, "\s").countTokens();
            number += row_words;
        }
        return number;
    }

    public String[] spaceAndWordsFilter(String[] file) {
        String[] new_file = new String[file.length];
        for (int i = 0; i < file.length; i++) {
            String new_row = "";
            StringTokenizer st = new StringTokenizer(file[i], "\s");
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (token.length() > 1) {
                    new_row += token + " ";
                }
            }
            new_file[i] = new_row;
            new_row = "";
            StringTokenizer st1 = new StringTokenizer(new_file[i], "\s");
            while (st1.hasMoreTokens()) {
                new_row += st1.nextToken();
                if (st1.hasMoreTokens()) {
                    new_row += " ";
                }
            }
            new_file[i] = new_row;
        }
        return new_file;
    }

    public String[] spaceFilter(String[] file) {
        String[] new_file = new String[file.length];
        for (int i = 0; i < file.length; i++) {
            String new_row = "";
            StringTokenizer st = new StringTokenizer(file[i], "\s");
            while (st.hasMoreTokens()) {
                new_row += st.nextToken();
                if (st.hasMoreTokens()) {
                    new_row += " ";
                }
            }
            new_file[i] = new_row;
        }
        return new_file;
    }

    public String[] spaceCreater(String[] file) {
        String[] new_file = new String[file.length];
        for (int i = 0; i < file.length; i++) {
            String new_row = "";
            StringTokenizer st = new StringTokenizer(file[i], "\s");
            int spaces = st.countTokens() - 1;
            if (spaces != 0) {
                int needed_spaces = 80;
                while (st.hasMoreTokens()) {
                    needed_spaces -= st.nextToken().length();
                }
                int insert_spaces = needed_spaces / spaces;
                String insert_space = "";
                for (int j = 0; j < insert_spaces; j++) {
                    insert_space += " ";
                }
                int rest_spaces = needed_spaces % spaces;
                StringTokenizer st1 = new StringTokenizer(file[i], "\s");
                while (st1.hasMoreTokens()) {
                    new_row += st1.nextToken();
                    if (st1.hasMoreTokens()) {
                        new_row += insert_space;
                    }
                    if (rest_spaces != 0) {
                        new_row += " ";
                        rest_spaces--;
                    }
                }
            } else {
                new_row = file[i];
            }
            new_file[i] = new_row;
        }
        return new_file;
    }
}

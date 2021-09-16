package com.company.Cw;

import java.util.Scanner;

public class t_01_01_04 {
    public void main() {
        //Inputting parameters for first object of Human class
        System.out.print("Input first age: ");
        Scanner sc11 = new Scanner(System.in);
        int age1 = sc11.nextInt();
        System.out.print("Input first height: ");
        Scanner sc12 = new Scanner(System.in);
        int height1 = sc12.nextInt();
        Human h1 = new Human(age1, height1);

        //Inputting parameters for second object of Human class
        System.out.print("Input second age: ");
        Scanner sc21 = new Scanner(System.in);
        int age2 = sc21.nextInt();
        System.out.print("Input second height: ");
        Scanner sc22 = new Scanner(System.in);
        int height2 = sc22.nextInt();
        Human h2 = new Human(age2, height2);

        //Showing results of inputting
        show_results(h1, h2); // second height will be saved for both objects, cause it's static field

        //Trying to change age and height for the first object
        System.out.print("Change first age: ");
        Scanner new_sc11 = new Scanner(System.in);
        h1.age = new_sc11.nextInt();
        System.out.print("Change first height: ");
        Scanner new_sc12 = new Scanner(System.in);
        h1.height = new_sc12.nextInt();

        //Showing results of changing
        show_results(h1, h2); //the mean of second height will be changed as well as mean of first height

        //obviously, that mean of age will be changed only for the first object
        //cause this variable applies to object, not to whole class
    }

    private void show_results(Human h1, Human h2) {
        /*Function for outputting parameters of two objects of Human class*/
        System.out.println();
        System.out.println("Age first human: " + h1.age + " (public variable)");
        System.out.println("Age second human: " + h2.age + " (public variable");
        System.out.println("Height first human: " + h1.height + " (public static variable)");
        System.out.println("Height first human: " + h2.height + " (public static variable)");
        System.out.println();
    }
}

class Human {
    public int age;
    public static int height;

    public Human(int age, int height) {
        this.age = age;
        this.height = height;
    }
}

package com.company.Hw;


import java.time.LocalTime;
import java.util.Objects;
import java.util.Scanner;

public class t_04_02_12 {
    public void main(String[] args) {
        Airline[] als = new Airline[5];
        for (int i = 0; i < 5; i++) {
            Scanner sc_dest = new Scanner(System.in);
            String dest = sc_dest.nextLine();
            Scanner sc_number = new Scanner(System.in);
            int number = sc_number.nextInt();
            Scanner sc_type = new Scanner(System.in);
            String type = sc_type.nextLine();
            Scanner sc_time = new Scanner(System.in);
            LocalTime time = LocalTime.parse(sc_time.nextLine());
            Scanner sc_day = new Scanner(System.in);
            String day = sc_day.nextLine();
            als[i] = new Airline(dest, number, type, time, day);
        }
        System.out.println("By dest:");
        String dest = args[0];
        getDestAls(als, dest);
        System.out.println("By day:");
        String day = args[1];
        getDayAls(als, day);
        System.out.println("By time:");
        LocalTime time = LocalTime.parse(args[2]);
        getTimeAls(als, day, time);
    }

    private void getDestAls(Airline[] als, String dest) {
        for (Airline al : als) {
            if (Objects.equals(al.getDest(), dest)) {
                System.out.println(al);
            }
        }
    }

    private void getDayAls(Airline[] als, String day) {
        for (Airline al : als) {
            if (Objects.equals(al.getDay(), day)) {
                System.out.println(al);
            }
        }
    }

    private void getTimeAls(Airline[] als, String day, LocalTime time) {
        for (Airline al : als) {
            if ((time.compareTo(al.getTime()) < 0) &
                    (Objects.equals(al.getDay(), day))) {
                System.out.println(al);
            }
        }
    }
}


class Airline {
    private String dest;
    private int number;
    private String type;
    private LocalTime time;
    private String day;

    public Airline() {
    }

    public Airline(String dest, int number, String type, LocalTime
            time, String day) {
        setAirline(dest, number, type, time, day);
    }

    public void setAirline(String dest, int number, String type, LocalTime time, String day) {
        this.dest = dest;
        this.number = number;
        this.type = type;
        this.time = time;
        this.day = day;
    }

    public Airline getAirline() {
        return this;
    }

    public String getDest() {
        return dest;
    }

    public String getDay() {
        return day;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Airline: " + dest + " " + number + " " +
                type + " " + time + " " + day;
    }
}

package com.company.Cw;

public class t_03_03_04 {
    public void main() {
        YourMessage y_mess = new YourMessage("Bob");
    }
}

class YourMessage {
    public YourMessage() {
        System.out.println("Welcome in 'Message' class!");
    }

    public YourMessage(String name) {
        System.out.println("Welcome, " + name + ", in 'Message' class!");
    }
}

package com.company.Cw;

public class t_03_03_06 {
    public void main() {
        DogSpeech ds1 = new DogSpeech();
        ds1.bark("Buff!");
        DogSpeech ds2 = new DogSpeech();
        ds2.bark("Yaff!", "Ooooooowhooo!!!");
    }
}

class DogSpeech {
    public void bark(String barking) {
        System.out.println("Dog says: " + barking);
    }

    public void bark(String barking, String howling) {
        System.out.println("Dog says: " + barking + " " + howling);
    }
}

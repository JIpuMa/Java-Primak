package com.company.Cw;

public class t_03_03_05 {
    public void main() {
        Dog d1 = new Dog("spot", "Ruff!");
        Dog d2 = new Dog("scruffy", "Wurf!");
        System.out.printf("Dog %s says: '%s'\n", d1.get_name(), d1.get_say());
        System.out.printf("Dog %s says: '%s'\n", d2.get_name(), d2.get_say());
        Dog d3 = d1;
        System.out.printf("d1 == d3: %b\n",d1 == d3);
        System.out.printf("d1.equals(d3): %b\n", d1.equals(d3));

    }
}

class Dog {
    private String name;
    private String say;

    public Dog(String name, String say) {
        this.name = name;
        this.say = say;
    }

    public String get_name() {
        return name;
    }

    public String get_say() {
        return say;
    }
}

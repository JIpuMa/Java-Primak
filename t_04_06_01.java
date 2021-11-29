package com.company.Cw;

import java.util.*;

public class t_04_06_01 {
    public void main() {
        Flower[] flowers = {
                new Rose(10.1, 1),
                new Rose(7, 1.2),
                new Lily(9.9, 0.5),
                new Lily(11, 2.4),
                new Rose(7, 2)
        };
        Bouquet bouquet = new Bouquet(flowers);
        System.out.println(bouquet);
        bouquet.sort();
        System.out.println(bouquet);
        System.out.println(bouquet.getByLen(8, 11));
        System.out.println("Bouquet price: " + bouquet.price());
    }
}

abstract class Flower {
    private double len;
    private double fresh;
    private double price;

    public Flower(double len, double fresh) {
        setLen(len);
        setFresh(fresh);
        setPrice(len, fresh);
    }

    public void setLen(double len) {
        this.len = len;
    }

    public double getLen() {
        return len;
    }

    public void setFresh(double fresh) {
        this.fresh = fresh;
    }

    public double getFresh() {
        return fresh;
    }

    public void setPrice(double len, double fresh) {
        this.price = len * fresh;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "len=" + len + ", fresh=" + fresh + ", price=" + price + '}';
    }

    public static int compare(Flower f1, Flower f2) {
        return Double.compare(f1.getFresh(), f2.getFresh());
    }
}

class Rose extends Flower {
    public Rose(double len, double fresh) {
        super(len, fresh);
    }

    @Override
    public String toString() {
        return "Rose: " + super.toString();
    }
}

class Lily extends Flower {
    public Lily(double len, double fresh) {
        super(len, fresh);
    }

    @Override
    public String toString() {
        return "Lily: " + super.toString();
    }
}

class Bouquet {
    private Flower[] flowers;

    public Bouquet(Flower[] flowers) {
        setFlowers(flowers);
    }

    public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public double price() {
        double price = 0;
        for (Flower flower : flowers) {
            price += flower.getPrice();
        }
        return price;
    }

    public void sort() {
        Arrays.sort(this.getFlowers(), Comparator.comparingDouble(Flower::getFresh));
    }

    public Bouquet getByLen(double min, double max) {
        ArrayList<Flower> flowers = new ArrayList<>();
        for (Flower flower : this.getFlowers()) {
            if (min < flower.getLen() && flower.getLen() < max) {
                flowers.add(flower);
            }
        }
        return new Bouquet(flowers.toArray(new Flower[0]));
    }

    @Override
    public String toString() {
        return "Bouquet: {" +
                "\nflowers=" + Arrays.toString(flowers) +
                "\n}";
    }
}

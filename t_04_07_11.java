package com.company.Cw;

public class t_04_07_11 {
    public void main() {
        Suit suit = new Suit(31, "black", "cotton", "italian");
        System.out.println(suit);
        Shoes shoes = new Shoes(43, "brown", "skin", "gucci");
        System.out.println(shoes);
    }
}

interface Fabric {
    void color();

    void type();
}

abstract class Clothes implements Fabric {
    private int size;
    private String color;
    private String type;

    public Clothes(int size, String color, String type) {
        setSize(size);
        setColor(color);
        setType(type);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setColor(String color) {
        this.color = color;
        this.color();
    }

    public String getColor() {
        return color;
    }

    public void setType(String type) {
        this.type = type;
        this.type();
    }

    public String getType() {
        return type;
    }

    @Override
    public void color() {
        System.out.println("Color: " + this.color);
    }

    @Override
    public void type() {
        System.out.println("Type: " + this.type);
    }

    @Override
    public String toString() {
        return "size=" + size + ", color=" + color;
    }
}

class Suit extends Clothes {
    private String style;

    public Suit(int size, String color, String type, String style) {
        super(size, color, type);
        setStyle(style);
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    @Override
    public String toString() {
        return "Suit: " + super.toString() + ", style=" + style;
    }
}

class Shoes extends Clothes {
    private String brand;

    public Shoes(int size, String color, String type, String brand) {
        super(size, color, type);
        setBrand(brand);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Shoes: " + super.toString() + ", brand=" + brand;
    }
}

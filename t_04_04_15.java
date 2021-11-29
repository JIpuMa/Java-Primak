package com.company.Hw;


import java.util.Scanner;

public class t_04_04_15 {
    public void main() {
        int m;
        do {
            System.out.print("Import m(m>2): ");
            Scanner sc_m = new Scanner(System.in);
            m = sc_m.nextInt();
        } while (m <= 3);
        Vector[] array = new Vector[m];
        for (int i = 0; i < m; i++) {
            System.out.println("Vector " + (i+1));
            System.out.print("x: ");
            Scanner sc_x = new Scanner(System.in);
            int x = sc_x.nextInt();
            System.out.print("y: ");
            Scanner sc_y = new Scanner(System.in);
            int y = sc_y.nextInt();
            System.out.print("z: ");
            Scanner sc_z = new Scanner(System.in);
            int z = sc_z.nextInt();
            array[i] = new Vector(x, y, z);
        }
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                for (int k = j; k < m; k++) {
                    if (i != j && j != k) {
                        String answer;
                        if (Vector.coplanarity(array[i], array[j], array[k])) {
                            answer = "are coplanar";
                        } else {
                            answer = "aren't coplanar";
                        }
                        System.out.println("Vectors " + array[i] + ", " + array[j] + ", " + array[k] + " - " + answer);
                    }
                }
            }
        }
    }
}

class Vector {
    private int x;
    private int y;
    private int z;

    public Vector() {}

    public Vector(int x, int y, int z) {
        setVector(x, y, z);
    }

    public void setVector(int x, int y, int z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public Vector getVector() {
        return this;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getZ() {
        return this.z;
    }

    public static boolean orthogonality(Vector v1, Vector v2) {
        return v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ() == 0;
    }

    public static boolean compare(Vector v1, Vector v2) {
        return (v1.getX() == v2.getX()) && (v1.getY() == v2.getY()) && (v1.getZ() == v2.getZ());
    }

    public static boolean coplanarity(Vector v1, Vector v2, Vector v3) {
        int det = v1.getX()*v2.getY()*v3.getZ() - v1.getX()*v2.getZ()*v3.getY() +
                v1.getY()*v2.getX()*v3.getZ() - v1.getY()*v2.getZ()*v3.getX() +
                v1.getZ()*v2.getX()*v3.getY() - v1.getZ()*v2.getY()*v3.getX();
        return det == 0;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", this.x, this.y, this.z);
    }
}

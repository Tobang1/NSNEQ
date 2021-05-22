package com.borat.NSON;

public class Category {
    public static final int SUJECTS = 1;
    public static final int PHYSICS = 2;
    public static final int BIOLOGY =3;
    public static final int CHEMISTRY = 4;
    public static final int MATHEMATICS = 5;
    public static final int Current_Affairs = 6;

    private int id;
    private String name;

    public  Category(){
    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return getName();
    }
}
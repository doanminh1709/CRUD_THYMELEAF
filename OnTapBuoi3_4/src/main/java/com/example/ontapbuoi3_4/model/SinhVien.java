package com.example.ontapbuoi3_4.model;

public class SinhVien {

    private static int temp = 1;
    private int id;
    private String name;
    private String email;

    public SinhVien(String name, String email) {
        this.id = temp++;
        this.name = name;
        this.email = email;
    }

    public SinhVien() {
        this.id = temp++;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.example.kaoshi.pojo;

import java.util.Objects;

public class Student {

    private String name;
    private String biahao;

    public Student(String name, String biahao) {
        this.name = name;
        this.biahao = biahao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(biahao, student.biahao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, biahao);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiahao() {
        return biahao;
    }

    public void setBiahao(String biahao) {
        this.biahao = biahao;
    }
}

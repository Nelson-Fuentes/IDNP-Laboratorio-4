package com.idnp.laboratorio4.models;

import java.io.Serializable;

public class Student implements Serializable {

    private int cui;
    private String apellidos;
    private String nombres;

    public Student(int cui, String apellidos, String nombres) {
        this.cui = cui;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }

    public int getCui() {
        return cui;
    }

    public void setCui(int cui) {
        this.cui = cui;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public String toString() {
        return "Student{" +
                "cui=" + cui +
                ", apellidos='" + apellidos + '\'' +
                ", nombres='" + nombres + '\'' +
                '}';
    }
}

package com.portfolio.web.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud minima")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud minima")
    private String apellido;

    @NotNull
    private String tituloProfesion;

    @NotNull
    private String descripcion;

    private String img;

    //constructores
    public Persona() {
    }

    public Persona(String nombre, String apellido, String tituloProfesion, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.tituloProfesion = tituloProfesion;
        this.img = img;
    }

    //setters y getters 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTituloProfesion(String tituloProfesion) {
        this.tituloProfesion = tituloProfesion;
    }

    public String getTituloProfesion() {
        return tituloProfesion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}

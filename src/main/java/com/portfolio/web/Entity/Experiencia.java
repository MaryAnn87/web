package com.portfolio.web.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String tituloPuesto;
    private String periodo;
    private String descripcionE;
    
    
    //constructores

    public Experiencia() {
    }

    public Experiencia(String nombreE, String tituloPuesto, String periodo, String descripcionE) {
        this.nombreE = nombreE;
        this.tituloPuesto = tituloPuesto;
        this.periodo = periodo;
        this.descripcionE = descripcionE;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getTituloPuesto() {
        return tituloPuesto;
    }

    public void setTituloPuesto(String tituloPuesto) {
        this.tituloPuesto = tituloPuesto;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
}

    
    

    
package com.portfolio.web.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombrePr;
    private String descripcionPr;
    private String linkPr;
    
    //constructores

    public Proyecto() {
    }

    public Proyecto(String nombrePr, String descripcionPr, String linkPr) {
        this.nombrePr = nombrePr;
        this.descripcionPr = descripcionPr;
        this.linkPr = linkPr;
    }
    
    
    
    
    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePr() {
        return nombrePr;
    }

    public void setNombrePr(String nombrePr) {
        this.nombrePr = nombrePr;
    }

    public String getDescripcionPr() {
        return descripcionPr;
    }

    public void setDescripcionPr(String descripcionPr) {
        this.descripcionPr = descripcionPr;
    }

    public String getLinkPr() {
        return linkPr;
    }

    public void setLinkPr(String linkPr) {
        this.linkPr = linkPr;
    }
    
   
}

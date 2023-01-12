package com.portfolio.web.Dto;

import javax.validation.constraints.NotBlank;


public class DtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String tituloPuesto;
    @NotBlank
    private String periodo;      
    @NotBlank
    private String descripcionE;
    
    //Constructores

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String tituloPuesto, String periodo, String descripcionE) {
        this.nombreE = nombreE;
        this.tituloPuesto = tituloPuesto;
        this.periodo = periodo;
        this.descripcionE = descripcionE;
    }

        
    //Getters & Setters

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

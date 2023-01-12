
package com.portfolio.web.Dto;

import javax.validation.constraints.NotBlank;


public class DtoEducacion {
    @NotBlank
    private String nombreInstitucion;
    @NotBlank
    private String tituloEd;
    @NotBlank
    private String periodo;      
    @NotBlank
    private String descripcionEd;
      
 //Constructores
    public DtoEducacion() {
    }

    public DtoEducacion(String nombreInstitucion, String tituloEd, String periodo, String descripcionEd) {
        this.nombreInstitucion = nombreInstitucion;
        this.tituloEd = tituloEd;
        this.periodo = periodo;
        this.descripcionEd = descripcionEd;
    }
    
 //Getters & Setters

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getTituloEd() {
        return tituloEd;
    }

    public void setTituloEd(String tituloEd) {
        this.tituloEd = tituloEd;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }
    
    
}

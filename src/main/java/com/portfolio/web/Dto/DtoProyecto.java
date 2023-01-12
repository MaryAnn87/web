package com.portfolio.web.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyecto {

    @NotBlank
    private String nombrePr;
    @NotBlank
    private String descripcionPr;
    @NotBlank
    private String linkPr;

    //constructores
    public DtoProyecto() {
    }

    public DtoProyecto(String nombrePr, String descripcionPr, String linkPr) {
        this.nombrePr = nombrePr;
        this.descripcionPr = descripcionPr;
        this.linkPr = linkPr;
    }

    //getters & setters
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

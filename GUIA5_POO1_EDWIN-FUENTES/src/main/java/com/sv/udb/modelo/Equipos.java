/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Estudiante
 */
public class Equipos {
    private int codi_equi;
    private String nom_equi;
    private String desc_equi;

    public Equipos() {
    }

    public Equipos(int codi_equi, String nom_equi, String desc_equi) {
        this.codi_equi = codi_equi;
        this.nom_equi = nom_equi;
        this.desc_equi = desc_equi;
    }

    public String getNom_equi() {
        return nom_equi;
    }

    public void setNom_equi(String nom_equi) {
        this.nom_equi = nom_equi;
    }

    public String getDesc_equi() {
        return desc_equi;
    }

    public void setDesc_equi(String desc_equi) {
        this.desc_equi = desc_equi;
    }

    public int getCodi_equi() {
        return codi_equi;
    }

    public void setCodi_equi(int codi_equi) {
        this.codi_equi = codi_equi;
    }

    @Override
    public String toString() {
        return getNom_equi();
    }
    
    
}

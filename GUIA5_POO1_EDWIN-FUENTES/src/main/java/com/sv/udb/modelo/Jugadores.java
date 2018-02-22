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
public class Jugadores {
    private int cod_equi;
    private String nom_juga;
    private int edad_juga;
    private int altu_juga;
    private String peso_juga;

    public Jugadores() {
    }

    public Jugadores(int cod_equi, String nom_juga, int edad_juga, int altu_juga, String peso_juga) {
        this.cod_equi = cod_equi;
        this.nom_juga = nom_juga;
        this.edad_juga = edad_juga;
        this.altu_juga = altu_juga;
        this.peso_juga = peso_juga;
    }

    public int getCod_equi() {
        return cod_equi;
    }

    public void setCod_equi(int cod_equi) {
        this.cod_equi = cod_equi;
    }

    public String getNom_juga() {
        return nom_juga;
    }

    public void setNom_juga(String nom_juga) {
        this.nom_juga = nom_juga;
    }

    public int getEdad_juga() {
        return edad_juga;
    }

    public void setEdad_juga(int edad_juga) {
        this.edad_juga = edad_juga;
    }

    public int getAltu_juga() {
        return altu_juga;
    }

    public void setAltu_juga(int altu_juga) {
        this.altu_juga = altu_juga;
    }

    public String getPeso_juga() {
        return peso_juga;
    }

    public void setPeso_juga(String peso_juga) {
        this.peso_juga = peso_juga;
    }
    
    
}

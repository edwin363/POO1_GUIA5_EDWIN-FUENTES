/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Estudiante
 */
public class EquiposCtrl {
    private final Connection conn;

    public EquiposCtrl() {
        this.conn = new Conexion().getConn();
    }
    
    public boolean guardar(String nom_equi, String desc_equi){
        boolean resp = false;
        try {
            PreparedStatement cmd = this.conn.prepareStatement("INSERT INTO equipos VALUES(NULL, ?, ?)");
            cmd.setString(1, nom_equi);
            cmd.setString(2, desc_equi);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(this.conn != null){
                    if(!this.conn.isClosed()){
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return resp;
    }
}

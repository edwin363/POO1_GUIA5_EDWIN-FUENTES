/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Equipos;
import com.sv.udb.modelo.Jugadores;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class JugadoresCtrl {

    private final Connection conn;

    public JugadoresCtrl() {
        this.conn = new Conexion().getConn();
    }

    public boolean guardarJug(int codi_equi, String nomb_juga, int edad_juga, int altu_juga, int peso_juga) {
        boolean resp = false;
        try {
            PreparedStatement cmd = this.conn.prepareStatement("INSERT INTO jugadores VALUES(NULL, ?, ?, ?, ?, ?)");
            cmd.setInt(1, codi_equi);
            cmd.setString(2, nomb_juga);
            cmd.setInt(3, edad_juga);
            cmd.setInt(4, altu_juga);
            cmd.setInt(5, peso_juga);
            cmd.executeUpdate();
            resp = true;
        } catch (SQLException ex) {
            System.err.println("Error al guardar Equipos: " + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return resp;
    }

    public List<Jugadores> consTodo1() {
        List<Jugadores> resp = new ArrayList<>();
        try {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT * FROM jugadores");
            ResultSet rs = cmd.executeQuery();
            
            //("SELECT j.codi_juga, e.*, j.nomb_juga, j.edad_juga, j.altu_juga, j.peso_juga FROM jugadores j INNER JOIN equipos e ON j.codi_equi = e.codi_equi
            while (rs.next()) {
                resp.add(new Jugadores(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar Jugadores: " + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }

   public boolean eliminarJug(int codigo){
       boolean resp = false;
       try {
           PreparedStatement cmd = this.conn.prepareStatement("DELETE FROM Jugadores WHERE codi_juga = ?");
           cmd.setInt(1, codigo);
           cmd.executeUpdate();
           resp = true;
       } catch (Exception e) {
           e.printStackTrace();
       }
       finally{
           try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión");
            }
       }
       return resp;
   }
   
   public boolean modificarJug(int codiEqui, String nombreJug, int edadJug, int alturaJug, int peso){
       boolean resp = false;
       try {
           PreparedStatement cmd = this.conn.prepareStatement("UPDATE jugadores SET codi_equi = ?, nomb_juga = ?, edad_juga = ?, altu_juga = ?, peso_juga = ?");
           cmd.setInt(1, codiEqui);
           cmd.setString(2, nombreJug);
           cmd.setInt(3, edadJug);
           cmd.setInt(4, alturaJug);
           cmd.setInt(5, peso);
           resp = true;
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return resp;
   }
}

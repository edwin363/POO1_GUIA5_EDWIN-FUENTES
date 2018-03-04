/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Equipos;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

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
    
    public List<Equipos> consTodo()
    {
       List<Equipos> resp = new ArrayList<>();
        try
        {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT * FROM equipos");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Equipos(rs.getInt(1),rs.getString(2), rs.getString(3)));
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error al consultar Equipos: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(this.conn != null)
                {
                    if(!this.conn.isClosed())
                    {
                        this.conn.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
    
    public boolean eliminar(int codEquip){
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("DELETE FROM equipos WHERE codi_equi = '" + codEquip + "' ");
            cmd.executeUpdate();
            resp=true;
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
    
    public boolean editar(String nombreEqui, String desEqui, int CodEqui){
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("UPDATE equipos SET nomb_equi = ?, desc_equi= ? WHERE codi_equi = ?");
            cmd.setString(1, nombreEqui);
            cmd.setString(2, desEqui);
            cmd.setInt(3, CodEqui);
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
    
    public boolean consultar(String nombre){
        boolean resp = false;
        try {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT nomb_equi FROM equipos WHERE nomb_equi = '" +nombre+"'");
            ResultSet result= cmd.executeQuery();
            while(result.next()){
                resp=true;
            }

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
    
        public List<Equipos> llenarCombo() {
        List<Equipos> resp = new ArrayList<>();
        try {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT * FROM equipos");
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                resp.add(new Equipos(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        
        public void getEquipos(JComboBox<Equipos> comboEquipos){
            try {
                PreparedStatement cmd = this.conn.prepareStatement("SELECT * FROM equipos");
                ResultSet rs = cmd.executeQuery();
                while(rs.next()){
                    comboEquipos.addItem(new Equipos(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
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
            
        }
        
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Ruben P
 */
public class Conexion {
    private Connection con;
    private PreparedStatement consulta;
    public ResultSet datos;
    private String server,user,bd,pass;
   
    
    public Conexion(){
    
     this.server="localhost";
        this.bd="proyecto";
        this.user="root";
        this.pass="root";
        
    
    }
    
    public void con() throws SQLException {
        
        try {
             Class.forName("com.mysql.jdbc.Driver");
        this.con=DriverManager.getConnection("jdbc:mysql://"+this.server+"/"+this.bd,this.user,this.pass);
        
        
        
           
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       

}
    public void desconectar() throws SQLException{
         this.con.close();
    }
    
   
    public ResultSet GetUser(String user, String Password) throws SQLException 
    {
    this.con();
    this.consulta=(PreparedStatement) this.con.prepareStatement("select * from admin where User='"+user+"' and Password='"+Password+"'");
    this.datos=this.consulta.executeQuery();
    return this.datos;
    }
    

   
    
    
}

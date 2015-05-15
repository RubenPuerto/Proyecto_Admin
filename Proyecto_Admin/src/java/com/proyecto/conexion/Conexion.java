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
import com.mysql.jdbc.PreparedStatement;
import java.io.*;
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
   
    public String SaveImg(String nombreProducto, String dirArchivo) throws SQLException{
        String inserto="";
        this.con();
        Connection cn=null;
        String sql="INSERT INTO producto(nombreProducto, nombreImagen, tamannoImagen, fotoProducto) ";
        sql+="VALUES(?,?,?,?)";
        try{
            this.consulta=(PreparedStatement) con.prepareStatement(sql);
            this.consulta.setString(1, nombreProducto);
            this.consulta.setString(2, nombreProducto+".jpg");
            //Parametros de la imagen
            File fichero = new File(dirArchivo);
            FileInputStream streamEntrada = new FileInputStream(fichero);
            int tamañoImagen = streamEntrada.available();
            //Establecer los parametros a la BD
            this.consulta.setInt(3, tamañoImagen);
            this.consulta.setBinaryStream(4, streamEntrada, (int) fichero.length());
            consulta.executeQuery();
            
        }catch (Exception e) {
        }finally{
            try{
                this.consulta.close();
                cn.close();
            }catch(Exception ex){

            }
        }
        return inserto;
        
                
    }

   

    
}

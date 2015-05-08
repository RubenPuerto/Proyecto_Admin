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
    
   
    public ResultSet getCursos() throws SQLException 
    {
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("select * from programas");
    this.datos=this.consulta.executeQuery();
    return this.datos;
    }
    
    public ResultSet llenarTema(String ID) throws SQLException 
    {
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("select * from Temas where IdPadre="+ID+"");
    this.datos=this.consulta.executeQuery();
    return this.datos;
    }
    
    public ResultSet llenarDescripcion(String IdTemas) throws SQLException 
    {
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("select Descripcion,ImgTema from temas where IdTemas="+IdTemas+"");
    this.datos=this.consulta.executeQuery();
    return this.datos;
    }
    
    
    public ResultSet ContadorInscritos(String IdTemas) throws SQLException{
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("SELECT COUNT(*) AS personas FROM newpeople where IdTema="+IdTemas+";");
    this.datos=this.consulta.executeQuery();
    return this.datos;
    }
    public ResultSet GuardarPersonas(String IdCurso,String IdTemas,String Correo) throws SQLException{
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("insert into newpeople(IdCurso,IdTema,Correo)values("+IdCurso+","+IdTemas+",'"+Correo+"');");
    this.consulta.executeUpdate();
    return this.datos;
    }
    public ResultSet llenarcurso(String IdCurso) throws SQLException 
    {
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("select * from programas where IdCurso="+IdCurso+"");
    this.datos=this.consulta.executeQuery();
    return this.datos;
    }
    public ResultSet GuardarCursos(String nombre,String apellido) throws SQLException{
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("INSERT INTO `proyecto`.`programas` (`TituloCurso`, `DescripcionCurso`) VALUES ('"+nombre+"', '"+apellido+"');");
    this.consulta.executeUpdate();
    return this.datos;
    }
    
     public ResultSet PedirCursos(String nombre,String Correo, String Celular) throws SQLException{
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("INSERT INTO `proyecto`.`cursonuevos` (`Nombre`, `Correo`,`Celular`) VALUES ('"+nombre+"', '"+Correo+"','"+Celular+"');");
    this.consulta.executeUpdate();
    return this.datos;
    }
   
    
    
}

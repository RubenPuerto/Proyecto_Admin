/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.conexion;

import com.mysql.jdbc.PreparedStatement;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ruben P
 */
public class Conexion {
    private Connection con;
    public PreparedStatement consulta;
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
    public ResultSet GetUser(String user, String Password) throws SQLException 
    {
    this.con();
    this.consulta=(PreparedStatement) this.con.prepareStatement("select * from admin where User='"+user+"' and Password='"+Password+"'");
    this.datos=this.consulta.executeQuery();
    return this.datos;
    }
    public ResultSet EliminarItem(String Id) throws SQLException{
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("DELETE FROM `proyecto`.`programas` WHERE `IdCurso`='"+Id+"';");
    this.consulta.executeUpdate();
    return this.datos;
    }
    public ResultSet getBanner() throws SQLException 
    {
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("select * from banner");
    this.datos=this.consulta.executeQuery();
    return this.datos;
    }
    public ResultSet getTemas() throws SQLException 
    {
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("SELECT a.IdTemas, a.Costo, a.Descripcion, a.Titulo, b.TituloCurso FROM proyecto.temas a inner join programas b on a.idPadre= b.IdCurso;");
    this.datos=this.consulta.executeQuery();
    return this.datos;
    }
    public ResultSet SaveBanner(String Nombre, String Url, InputStream ContentPhotoBanner  ) throws SQLException{
    this.con();
    String sql = "INSERT INTO banner (Nombre, Url, Img) values ( ?, ?, ?)";
    this.consulta=(PreparedStatement) this.con.prepareStatement(sql);
    this.consulta.setString(1, Nombre);
    this.consulta.setString(2, Url);
    this.consulta.setBlob(3, ContentPhotoBanner);
    this.consulta.executeUpdate();
    return this.datos;
    }
    public ResultSet SavePrograma(String titulo, InputStream ContentPhotoDetalle, String IdVideo, String Descripcion, InputStream ContentPhotoHome ) throws SQLException{
    this.con();
    String sql = "INSERT INTO programas (TituloCurso, ImagenCurso, IdVideo, DescripcionCurso, ImgCursosInicio) values ( ?, ?, ?, ?, ?)";
    this.consulta=(PreparedStatement) this.con.prepareStatement(sql);
    this.consulta.setString(1, titulo);
    this.consulta.setBlob(2, ContentPhotoDetalle);
    this.consulta.setString(3, IdVideo);
    this.consulta.setString(4, Descripcion);
    this.consulta.setBlob(5, ContentPhotoHome);
    consulta.executeUpdate();
    return this.datos;
    }
    public ResultSet SaveTema(String IdCurso, String Costo, String Descripcion, String Titulo, InputStream ContentPhotoTema  ) throws SQLException{
    this.con();
    String sql = "INSERT INTO Temas (IdPadre, Costo, Descripcion, Titulo, ImgTema) values ( ?, ?, ?, ?, ?)";
    this.consulta=(PreparedStatement) this.con.prepareStatement(sql);
    this.consulta.setString(1, IdCurso);
    this.consulta.setString(2, Costo);
    this.consulta.setString(3, Descripcion);
    this.consulta.setString(4, Titulo);
    this.consulta.setBlob(5, ContentPhotoTema);
    consulta.executeUpdate();
    return this.datos;
    }
    public ResultSet EliminarCurso(String Id) throws SQLException{
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("DELETE FROM `proyecto`.`temas` WHERE `IdTemas`='"+Id+"';");
    this.consulta.executeUpdate();
    return this.datos;
    }
    public ResultSet EliminarBanner(String Id) throws SQLException{
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("DELETE FROM `proyecto`.`banner` WHERE `Id`='"+Id+"';");
    this.consulta.executeUpdate();
    return this.datos;
    }
    public ResultSet getItemBanner(String id) throws SQLException 
    {
    this.con();

    this.consulta=(PreparedStatement) this.con.prepareStatement("SELECT * from banner where Id='"+id+"'");
    this.datos=this.consulta.executeQuery();
    return this.datos;
    }
    public ResultSet getItemCursos(String Id) throws SQLException 
    {
    this.con();
    this.consulta=(PreparedStatement) this.con.prepareStatement("select * from programas where IdCurso="+Id+"");
    this.datos=this.consulta.executeQuery();
    return this.datos;
    }
    
    
    
}

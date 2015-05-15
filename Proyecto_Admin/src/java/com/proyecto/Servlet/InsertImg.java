/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author rubenp
 */
public class InsertImg extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */ 
    private int codigo;
    private String nombre;
    private String nombreImagen;
    private int tamanno;
    private InputStream foto;
    //
    private String classFor="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost/proyecto";
    private String usuario="root";
    private String clave="root";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nombre=request.getParameter("nombre").toUpperCase();
            String direccion=request.getParameter("file").toUpperCase();
            out.println(direccion+" "+nombre);
            out.println("<br>");
            
            
            
        String inserto="";
        Connection cn=null;
        PreparedStatement pr=null;
        String sql="INSERT INTO producto(nombreProducto, nombreImagen, tamannoImagen, fotoProducto) ";
        sql+="VALUES(?,?,?,?)";
        try{
            out.println("entro al try");
            out.println("<br>");
            Class.forName(classFor);
            cn=DriverManager.getConnection(url, usuario,clave);
            pr=cn.prepareStatement(sql);
//            out.println(pr);
            pr.setString(1, nombre);
            pr.setString(2, nombre+".jpg");
            out.println(pr);
            out.println("<br>");
            //Parametros de la imagen
            File fichero = new File(direccion);
            FileInputStream streamEntrada = new FileInputStream("/autoexec.bat");
//            FileInputStream pruebas=new FileInputStream("/autoexec.bat");
            int tamañoImagen = 100;
            //Establecer los parametros a la BD
//            out.println(streamEntrada);
            out.println("<br>");
            out.println(fichero);
            out.println("<br>");
            out.println(tamañoImagen);
            out.println("<br>");
            pr.setInt(3, tamañoImagen);
            out.println("<br>");
            out.println(pr);
            out.println("<br>");
//            pr.setBinaryStream(4, streamEntrada, (int) fichero.length());
//            out.println(pr);
            if(pr.executeUpdate()==1){
                inserto="Se inserto el producto de forma correcta";
            }else{
                inserto="No se pudo insertar al producto"; 
            }
        }catch(Exception ex){
            inserto=ex.getMessage();
        }
        
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

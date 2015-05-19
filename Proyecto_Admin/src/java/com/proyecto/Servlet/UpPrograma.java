/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author RUBEN
 */
@MultipartConfig(maxFileSize = 16177215) 
public class UpPrograma extends HttpServlet {
    
    private String dbURL = "jdbc:mysql://localhost:3306/proyecto";
    private String dbUser = "root";
    private String dbPass = "root";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String titulo=request.getParameter("Titulo");
            String IdVideo=request.getParameter("IdVideo");
            String Descripcion=request.getParameter("Descripcion");
            
            Part FilePhotoDetalle= request.getPart("PhotoDetalleCurso");
            Part FilePhotoHome=request.getPart("PhotoHome");
            
            InputStream ContentPhotoHome =null;
            InputStream ContentPhotoDetalle=null;
            
            out.println(titulo+" "+IdVideo+" "+Descripcion+"<br>");
            
        if (FilePhotoDetalle != null || FilePhotoHome != null) {
            // obtains input stream of the upload file
            ContentPhotoHome=FilePhotoHome.getInputStream();
            ContentPhotoDetalle=FilePhotoDetalle.getInputStream();
        }
        String message = null;
        Connection conn = null; // connection to the database
        
                try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
//                String sql = "INSERT INTO banner (Nombre, ImgBanner) values ( ?, ?)";
                String sql = "INSERT INTO programas (TituloCurso, ImagenCurso, IdVideo, DescripcionCurso, ImgCursosInicio) values ( ?, ?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                out.println(statement);
                statement.setString(1, titulo);
                statement.setBlob(2, ContentPhotoDetalle);
                statement.setString(3, IdVideo);
                statement.setString(4, Descripcion);
                statement.setBlob(5, ContentPhotoHome);
                statement.executeUpdate();
                
                
            } catch (SQLException ex) {
                out.println("error ruben");
                ex.printStackTrace();
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
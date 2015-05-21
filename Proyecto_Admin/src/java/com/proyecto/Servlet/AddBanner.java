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
public class AddBanner extends HttpServlet {
    private String dbURL = "jdbc:mysql://localhost:3306/proyecto";
    private String dbUser = "root";
    private String dbPass = "root";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String Nombre=request.getParameter("NombreBanner");
            String Url=request.getParameter("UrlBanner");
            
            System.out.println(Nombre+" "+Url);
            Part FilePhotoBanner = request.getPart("Photo");
                       
            InputStream ContentPhotoBanner = null;
            if (FilePhotoBanner != null) {
            // obtains input stream of the upload file
                System.out.println("entro al if");
            ContentPhotoBanner=FilePhotoBanner.getInputStream();
            
            }
            String message = null;
            Connection conn = null;
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
                String sql = "INSERT INTO banner (Nombre, Url, Img) values ( ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, Nombre);
                statement.setString(2, Url);
                statement.setBlob(3, ContentPhotoBanner);
                statement.executeUpdate();
                
            } catch (SQLException ex) {
                out.println(ex);
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

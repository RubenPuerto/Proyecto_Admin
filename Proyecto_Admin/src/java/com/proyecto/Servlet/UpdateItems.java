/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.Servlet;

import com.proyecto.conexion.Conexion;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
public class UpdateItems extends HttpServlet {

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
            String IdCurso=request.getParameter("IdPrograma");
            String titulo=request.getParameter("Titulo");
            String IdVideo=request.getParameter("IdVideo");
            String Descripcion=request.getParameter("Descripcion");
            Part FilePhotoDetalle= request.getPart("PhotoDetalleCurso");
            Part FilePhotoHome=request.getPart("PhotoHome");
            
            InputStream ContentPhotoHome =null;
            InputStream ContentPhotoDetalle=null;
            out.println(FilePhotoDetalle);
            long tamañoImagenDetalle =  FilePhotoDetalle.getSize();
            long tamañoImagenHome =  FilePhotoHome.getSize();
            if (FilePhotoDetalle != null && FilePhotoHome != null) {
            // obtains input stream of the upload file
                 
            ContentPhotoHome=FilePhotoHome.getInputStream();
            ContentPhotoDetalle=FilePhotoDetalle.getInputStream();
            }
            
            try {
                Conexion c=new Conexion();
                ResultSet rs=c.UpdatePrograma(IdCurso,titulo, ContentPhotoDetalle, IdVideo, Descripcion, ContentPhotoHome, tamañoImagenDetalle, tamañoImagenHome );
                String site = new String("guardo.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site);
            } catch (Exception e) {
                out.println("no se guardo nada");
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

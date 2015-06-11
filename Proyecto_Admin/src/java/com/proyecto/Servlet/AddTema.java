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
public class AddTema extends HttpServlet {

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
            String IdCurso=request.getParameter("Cursos");
            String Titulo=request.getParameter("TituloTema");
            String Descripcion=request.getParameter("DescripcionTema");
            String Costo=request.getParameter("CostoTema");
            
//            String IdCurso= "1";
//            String Titulo="pruebas";
//            String Descripcion="pruebas";
//            String Costo="1000";
            out.println(IdCurso);
            out.println(Titulo);
            out.println(Descripcion);
            out.println(Costo);
            
            Part PhotoTema = request.getPart("PhotoTema");
                       
            InputStream ContentPhotoTema = null;
            if (PhotoTema != null) {
            // obtains input stream of the upload file
            out.println("entro al if");   
            ContentPhotoTema=PhotoTema.getInputStream();
            
            }
            try {
                Conexion c=new Conexion();
                ResultSet rs=c.SaveTema(IdCurso, Costo, Descripcion, Titulo, ContentPhotoTema);
                String site = new String("guardo.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site);
            } catch (Exception e) {
                out.println("<div>No se guardo nada</div>");
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

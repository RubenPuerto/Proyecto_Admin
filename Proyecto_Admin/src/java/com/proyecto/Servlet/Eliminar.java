/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.Servlet;

import com.proyecto.conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RUBEN
 */
public class Eliminar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public Conexion c;
    public ResultSet rs;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            c=new Conexion();
            String id = request.getParameter("id");
            
            if(id.isEmpty()){
                out.println("No se puedo cargar llene todos los datos");
            }
            else {
                try {
                    rs=c.EliminarItem(id);
                    try {
                        ResultSet rs2=c.getCursos();
                        out.println("<thead>");
                        out.println("<tr>");
                        out.println("<td>IdCurso</td>");
                        out.println("<td>Curso</td>");
                        out.println("<td>Descripcion</td>");
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("<tbody>");
                        while(rs2.next())
                        {   
                            
                            out.println("<tr>");
                            out.println("<td>"+rs2.getInt("IdCurso")+"</td>");
                            out.println("<td>"+rs2.getString("TituloCurso")+"</td>");
                            out.println("<td>"+rs2.getString("DescripcionCurso") +"</td>");
                            out.println("</tr>");

                        }
                        out.println("<tbody>");
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                }
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

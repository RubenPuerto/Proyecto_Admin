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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rubenp
 */
public class ColumnEliminarCurso extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>IdPadre</th>");
            out.println("<th>Costo</th>");
            out.println("<th>Descripcion</th>");
            out.println("<th>Titulo</th>");
            out.println("<th>Imagen</th>");
            out.println("<th>Eliminar</th>");
            out.println("</tr>");
            out.println("</thead>");
            Conexion c=new Conexion();
            ResultSet rs=c.getTemas();
            out.println("<tbody>");
            while(rs.next())
            {   
                out.println("<tr>");
                out.println("<td>"+rs.getInt("IdTemas")+"</td>");
                out.println("<td>"+rs.getString("TituloCurso")+"</td>");
                out.println("<td>"+rs.getString("Costo") +"</td>");
                out.println("<td>"+rs.getString("Descripcion") +"</td>");
                out.println("<td>"+rs.getString("Titulo") +"</td>");
                out.println("<td> <input type='button' id='submit2' value='Ver Img'></td>");
                out.println("<td><input type='button' id='submit2' value='Eliminar'  onclick='EliminarCurso("+rs.getInt("IdTemas")+");' /></td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ColumnEliminarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ColumnEliminarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
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

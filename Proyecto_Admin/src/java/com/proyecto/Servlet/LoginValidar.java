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
import com.proyecto.conexion.Conexion;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RUBEN
 */
public class LoginValidar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Conexion c=new Conexion();
    ResultSet rs;
    String user;
    String Password;
    String usuario;
    String Contraseña;
    int b=0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            user=request.getParameter("usuario");
            Password=request.getParameter("pass");
            try {
                rs=c.GetUser(user,Password);
                while (rs.next()) { 
                   usuario=rs.getString("User");
                   Contraseña=rs.getString("Password");
                   if(usuario.equals(usuario) && Contraseña.equals(Password))
                    {
                        b=1;//si se cumple es 1
                    }else{
                        b=0; //sino es 0
                    } 
                }
                if (b==1){
                    String ja = new String (usuario);
                    HttpSession op = request.getSession();
                    op.putValue("varUsuario",ja);
                    out.println("<script>alert('Usuario Identificado Correctamente')</script>");
                    String url = request.getScheme() + "://" +   // "http" + "://
                                 request.getServerName() +       // "myhost"
                                 ":" +                           // ":"
                                 request.getServerPort()  +"/Proyecto_Admin/Administracion.jsp";     // "8080"
                                      // "/people"
                    response.sendRedirect(url);
                }else{
                    out.println("<script>alert('Datos Erroneos  ')</script>");
                    String url = request.getScheme() + "://" +   // "http" + "://
                                 request.getServerName() +       // "myhost"
                                 ":" +                           // ":"
                                 request.getServerPort() + "/Proyecto_Admin";       // "/people"
                    response.sendRedirect(url);
                }
            } catch (Exception e) {
                out.println("No hay conexion a la base de datos ");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.Servlet;

import com.proyecto.conexion.Conexion;
import com.sun.java.swing.plaf.windows.resources.windows;
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
public class AddBanner extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String Nombre=request.getParameter("NombreBanner");
            String Url=request.getParameter("UrlBanner");
            
            System.out.println(Nombre+" "+Url);
            Part FilePhotoBanner = request.getPart("Photo");
            long tamañoImagen =  FilePhotoBanner.getSize();
            
            InputStream ContentPhotoBanner = null;
            if (FilePhotoBanner != null) {
            // obtains input stream of the upload file
            ContentPhotoBanner=FilePhotoBanner.getInputStream();
            }
            try {
                Conexion c=new Conexion();
                ResultSet rs=c.SaveBanner(Nombre, Url, ContentPhotoBanner );
                String site = new String("guardo.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site);
            } catch (Exception e) {
                
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

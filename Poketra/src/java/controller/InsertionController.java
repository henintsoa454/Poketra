/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Look;
import model.Matiere;

/**
 *
 * @author ITU
 */
@WebServlet(name = "InsertionController", urlPatterns = {"/InsertionController"})
public class InsertionController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(request.getParameter("objet")!=null){
            String objet = request.getParameter("objet");
            if(objet.contains("matiere")){
                if(request.getParameter("nom")!=null){
                    try{
                        Matiere.inserer(request.getParameter("nom"));
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }else if(objet.contains("look")){
                try{
                        Look.inserer(request.getParameter("nom"));
                    }catch(Exception e){
                        e.printStackTrace();
                    }
            }
            RequestDispatcher rd = request.getRequestDispatcher("./index.html");
            rd.forward(request, response);
        }else{
            
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

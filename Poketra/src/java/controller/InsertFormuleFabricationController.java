/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FabricationPoketra;
import model.FormuleFabrication;
import model.LookMatiere;
import model.Type;

/**
 *
 * @author ITU
 */
@WebServlet(name = "InsertFormuleFabricationController", urlPatterns = {"/InsertFormuleFabricationController"})
public class InsertFormuleFabricationController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            if (request.getParameter("nom") != null && request.getParameter("taille") != null && request.getParameterValues("matiere") != null) {
                String type = request.getParameter("nom");
                String taille = request.getParameter("taille");
                String[] selectedMatiereIds = request.getParameterValues("matiere");
                String[] quantite = request.getParameterValues("quantite");
                if(selectedMatiereIds.length == quantite.length){
                    Type.inserer(type);
                    FabricationPoketra.inserer(Type.lastId(), Integer.parseInt(taille));
                    for(int i = 0; i < quantite.length; i++){
                        FormuleFabrication.inserer(FabricationPoketra.lastId(), Integer.parseInt(selectedMatiereIds[i]), Integer.parseInt(quantite[i]));
                    }
                }
            }
            response.sendRedirect("index.html");
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs éventuelles
            response.sendRedirect("PageErreur.jsp");
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
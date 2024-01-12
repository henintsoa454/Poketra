/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LookMatiere;
import model.Matiere;
import model.Taille;
import view.TypeFabricationPoketraFormuleFabrication;

/**
 *
 * @author ITU
 */
@WebServlet(name = "ListeMatierePoketraController", urlPatterns = {"/ListeMatierePoketraController"})
public class ListeMatierePoketraController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ArrayList<Matiere> allMatieres = Matiere.getAllMatieres();
            ArrayList<TypeFabricationPoketraFormuleFabrication> allResults = TypeFabricationPoketraFormuleFabrication.getAll();
            request.setAttribute("allMatieres", allMatieres);
            request.setAttribute("allTailles",Taille.getAllTailles());
            request.setAttribute("allResults", allResults);
            RequestDispatcher rd = request.getRequestDispatcher("./listeMatierePoketra.jsp");
            rd.forward(request, response);
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

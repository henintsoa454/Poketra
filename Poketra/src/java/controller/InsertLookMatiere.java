/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LookMatiere;

/**
 *
 * @author ITU
 */
@WebServlet(name = "InsertLookMatiere", urlPatterns = {"/InsertLookMatiere"})
public class InsertLookMatiere extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String selectedLookId = request.getParameter("look");
            String[] selectedMatiereIds = request.getParameterValues("matieres");

            if (selectedLookId != null && selectedMatiereIds != null) {
                int lookId = Integer.parseInt(selectedLookId);
                LookMatiere.resetLookMatiere(lookId);
                for (String matiereId : selectedMatiereIds) {
                    int idMatiere = Integer.parseInt(matiereId);
                    LookMatiere.inserer(lookId, idMatiere);
                }
            }

            // Redirection vers une page de confirmation ou autre
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StockMatiere;

/**
 *
 * @author ITU
 */
@WebServlet(name = "InsertStockMatiere", urlPatterns = {"/InsertStockMatiere"})
public class InsertStockMatiere extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            if (request.getParameter("matiere") != null && request.getParameter("quantite") != null) {
                StockMatiere.insererPlus(Integer.valueOf(request.getParameter("matiere")), Integer.valueOf(request.getParameter("quantite")), Date.valueOf(LocalDate.now()));
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

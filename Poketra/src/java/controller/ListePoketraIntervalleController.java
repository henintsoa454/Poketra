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
import model.Matiere;
import model.Type;
import view.TypeFabricationPoketraFormuleFabrication;

/**
 *
 * @author ITU
 */
@WebServlet(name = "ListePoketraIntervalleController", urlPatterns = {"/ListePoketraIntervalleController"})
public class ListePoketraIntervalleController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            if(request.getParameter("prixMin")!=null&&request.getParameter("prixMax")!=null){
                ArrayList<Type> alltypes = Type.getAllTypes();
                ArrayList<Type> results = new ArrayList<>();
                for(int i = 0; i < alltypes.size(); i++){
                    if(alltypes.get(i).getPrix() >= Double.parseDouble(request.getParameter("prixMin")) && alltypes.get(i).getPrix() <= Double.parseDouble(request.getParameter("prixMax"))){
                        results.add(alltypes.get(i));
                    }
                }
                System.out.println("Taille resultat : "+results.size());
                request.setAttribute("allResults", results);
                RequestDispatcher rd = request.getRequestDispatcher("./listePoketraPrix.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("hah");
         try {
            if(request.getParameter("prixMin")!=null&&request.getParameter("prixMax")!=null){
                ArrayList<Type> alltypes = Type.getAllTypes();
                ArrayList<Type> results = new ArrayList<>();
                for(int i = 0; i < alltypes.size(); i++){
                    if(alltypes.get(i).getPrix() >= Double.parseDouble(request.getParameter("prixMin")) && alltypes.get(i).getPrix() <= Double.parseDouble(request.getParameter("prixMax"))){
                        results.add(alltypes.get(i));
                    }
                }
                System.out.println("Taille resultat : "+results.size());
                request.setAttribute("allResults", results);
                RequestDispatcher rd = request.getRequestDispatcher("./listePoketraPrix.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

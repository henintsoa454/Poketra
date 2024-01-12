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
import model.FabricationPoketra;
import model.Matiere;
import model.Taille;
import model.Type;

/**
 *
 * @author ITU
 */
@WebServlet(name = "AjoutFabricationPoketraController", urlPatterns = {"/AjoutFabricationPoketraController"})
public class AjoutFabricationPoketraController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            ArrayList<FabricationPoketra> allFabricationPoketras = FabricationPoketra.getAll();
            ArrayList<Type> allTypes = new ArrayList<Type>();
            ArrayList<Taille> allTailles = new ArrayList<Taille>();
            for(int i = 0; i < allFabricationPoketras.size(); i++){
                allTypes.add(Type.getById(allFabricationPoketras.get(i).getIdType()));
                allTailles.add(Taille.getById(allFabricationPoketras.get(i).getIdTaille()));
            }
            request.setAttribute("allTypes", allTypes);
            request.setAttribute("allTailles", allTailles);
            RequestDispatcher rd = request.getRequestDispatcher("./listeMatierePoketra.jsp");
            rd.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
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

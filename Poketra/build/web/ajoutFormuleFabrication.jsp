<%@page import="model.Taille"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,model.Look,model.Matiere,model.LookMatiere"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajout Look Matiere</title>
</head>
<body>
    <h2>Association Look-Matiere</h2>
    <form action="InsertFormuleFabricationController" method="post">
        <label>Nom de la creation</label>
        <input type="text" name="nom" placeholder="Poketra">
        
        <label>Choisir la taille :</label>
        <select name="taille">
            <% 
                ArrayList<Taille> allTailles = (ArrayList<Taille>)(request.getAttribute("allTailles"));
                for(Taille taille : allTailles) {
            %>
            <option value="<%= taille.getId() %>"><%= taille.getNom() %></option>
            <% } %>
        </select>
        <label>Formule de fabrication :</label>
        <table>
            <tr>                
                <th>MATIERE</th>
                <th>QUANTITE</th>
            </tr>
            <%for (int i = 0; i < 3; i++) {%>
            <tr>
                <td>
                    <select name="matiere">
                        <% 
                            ArrayList<Matiere> allMatieres = (ArrayList<Matiere>)(request.getAttribute("allMatieres"));
                            for(Matiere matiere : allMatieres) {
                        %>
                        <option value="<%= matiere.getId() %>"><%= matiere.getNom() %></option>
                        <% } %>
                    </select>
                </td>
                <td><input type="text" name="quantite" placeholder="Quantite"></td>
            </tr>
            <%}%>
        </table>       
        <input type="submit" value="Enregistrer">
    </form>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,model.Look,model.Matiere,model.LookMatiere"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajout Stock Matiere</title>
</head>
<body>
    <h2>Association Look-Matiere</h2>
    <form action="InsertStockMatiere" method="post">
        <h3>Choisir une matière :</h3>
        <select name="matiere">
            <% 
                ArrayList<Matiere> allMatiere = (ArrayList<Matiere>)request.getAttribute("allMatieres");
                for(Matiere look : allMatiere) {
            %>
            <option value="<%= look.getId() %>"><%= look.getNom() %></option>
            <% } %>
        </select>
        
        <h3>Quantite :</h3>
        <input type="number" name="quantite" placeholder="quantite"><br>
        
        <br>
        <input type="submit" value="Enregistrer">
    </form>
</body>
</html>

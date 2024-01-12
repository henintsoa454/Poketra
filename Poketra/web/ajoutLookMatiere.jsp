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
    <form action="InsertLookMatiere" method="post">
        <h3>Choisir une matière :</h3>
        <select name="look">
            <% 
                ArrayList<Look> allLooks = (ArrayList<Look>)request.getAttribute("allLooks");
                for(Look look : allLooks) {
            %>
            <option value="<%= look.getId() %>"><%= look.getNom() %></option>
            <% } %>
        </select>
        
        <h3>Choisir les looks :</h3>
        <%  ArrayList<Matiere> allMatieres = (ArrayList<Matiere>)request.getAttribute("allMatieres");
            for(Matiere matiere : allMatieres) {
        %>
        <input type="checkbox" name="matieres" value="<%= matiere.getId() %>"><%= matiere.getNom() %><br>
        <% } %>
        
        <br>
        <input type="submit" value="Enregistrer">
    </form>
</body>
</html>

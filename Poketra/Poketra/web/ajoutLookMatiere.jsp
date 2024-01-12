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
    <form action="TraitementAssociationController" method="post">
        <h3>Choisir une matière :</h3>
        <select name="matiere">
            <% 
                ArrayList<Matiere> allMatieres = Matiere.getAllMatieres();
                for(Matiere matiere : allMatieres) {
            %>
            <option value="<%= matiere.getId() %>"><%= matiere.getNom() %></option>
            <% } %>
        </select>
        
        <h3>Choisir les looks :</h3>
        <% 
            ArrayList<Look> allLooks = Look.getAllLooks();
            for(Look look : allLooks) {
                ArrayList<Matiere> matieresByLook = LookMatiere.getAllMAtiereByLook(look.getId());
        %>
        <input type="checkbox" name="looks" value="<%= look.getId() %>"><%= look.getNom() %><br>
        <% } %>
        
        <br>
        <input type="submit" value="Enregistrer">
    </form>
</body>
</html>

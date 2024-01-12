<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,model.Look,model.Matiere,model.LookMatiere,model.Type"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Fabrication Poketra</title>
</head>
<body>
    <h2>Association Look-Matiere</h2>
    <form action="" method="post">
        <h3>Choisir une Poketra :</h3>
        <select name="matiere">
            <% 
                ArrayList<Type> allType = (ArrayList<Type>)request.getAttribute("allType");
                for(Type look : allType) {
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

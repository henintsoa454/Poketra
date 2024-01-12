
<%@page import="java.util.ArrayList"%>
<%@page import="model.Type"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trier(prix) Result</title>
    </head>
    <body>
        <% if(request.getAttribute("allResults")!=null){ %> 
        <table border = 1>
            <tr>
                <th>Sac</th>
                <th>Prix</th>
            </tr>
            
            <% for(Type type : (ArrayList<Type>)request.getAttribute("allResults")) { %>
            <tr>
                <td><%= type.getNom() %></td>
                <td><%= type.getPrix() %></td>
            </tr>  
            <% } %>
            
        </table>
         <% } else{%>
            <h3>Aucun resultat !!!</h3>
        <% } %>
    </body>
</html>

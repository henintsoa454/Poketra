
<%@page import="java.util.ArrayList"%>
<%@page import="model.Type"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Fabrication Poketra</title>
    </head>
    <body>
        <% if(request.getAttribute("allResults")!=null){ %> 
        <table border = 1>
            <tr>
                <th>Poketra</th>
                <th>quantite</th>
                <th>date action</th>
            </tr>
            
            <% for(HistoriqueFabrication type : (ArrayList<HistoriqueFabrication>)request.getAttribute("allResults")) { %>
            <tr>
                <td><%= type.getIdType() %></td>
                <td><%= type.getQuantite() %></td>
                <td><%= type.getDateAction() %></td>
            </tr>  
            <% } %>
            
        </table>
         <% } else{%>
            <h3>Aucun resultat !!!</h3>
        <% } %>
    </body>
</html>

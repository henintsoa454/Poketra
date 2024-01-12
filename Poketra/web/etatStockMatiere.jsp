
<%@page import="java.util.ArrayList"%>
<%@page import="model.Type"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EtatStckMatiere</title>
    </head>
    <body>
        <% if(request.getAttribute("allResults")!=null){ %> 
        <table border = 1>
            <tr>
                <th>Matiere</th>
                <th>quantite</th>
                <th>date action</th>
            </tr>
            
            <% for(StockMatiere type : (ArrayList<StockMatiere>)request.getAttribute("allResults")) { %>
            <tr>
                <td><%= type.getIdMatiere() %></td>
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

<%-- 
    Document   : listeMatiereLook.jsp
    Created on : 19 déc. 2023, 10:24:00
    Author     : ITU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,model.Look,model.LookMatiere,model.Matiere"%>
<%
    ArrayList<Look> allLooks = new ArrayList<>();
    if(request.getAttribute("allLooks")!=null){
        allLooks = ((ArrayList<Look>)request.getAttribute("allLooks"));
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="content-1">
            <h2>Liste des looks</h2>
            <form>
                <select name="look" id="selectLook" onchange="getMatiereData()">
                    <option>Liste des looks</option>
                    <% for(int i = 0; i < allLooks.size(); i++){ %>
                        <option value="<%= allLooks.get(i).getId()%>"><%= allLooks.get(i).getNom()%></option>
                    <% } %>
                </select>
            </form>
        </div>
        <div class="content-2">
            <table border="1" id="matiereTable">
                <tr>
                    <th>Matiere</th>
                </tr>
            </table>
        </div>
    </body>
    <script>
        function getMatiereData() {
            var selectedLookId = document.getElementById("selectLook").value;

            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        var matiereData = JSON.parse(xhr.responseText);
                        updateTable(matiereData);
                    } else {
                        console.error('Erreur : ' + xhr.status);
                    }
                }
            };

            xhr.open('GET', 'ListeMatiereJSON?lookId=' + selectedLookId, true);
            xhr.send();
        }

        function updateTable(matiereData) {
            var table = document.getElementById("matiereTable");
            table.innerHTML = ''; // Effacer le contenu actuel de la table
            table.headers = "Matieres";
            for (var i = 0; i < matiereData.length; i++) {
                var row = table.insertRow(i);
                var cell = row.insertCell(0);
                cell.innerHTML = matiereData[i].nom; // Adapter cette ligne selon votre modèle Matiere
            }
        }
    </script>
</html>
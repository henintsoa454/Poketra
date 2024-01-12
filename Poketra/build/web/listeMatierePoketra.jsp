<%@page import="model.Matiere"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Matiere> allMatieres = new ArrayList<>();
    if(request.getAttribute("allMatieres")!=null){
        allMatieres = ((ArrayList<Matiere>)request.getAttribute("allMatieres"));
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
                <select name="look" id="selectLook" onchange="getListePoketra()">
                    <option>Liste des matieres</option>
                    <% for(int i = 0; i < allMatieres.size(); i++){ %>
                        <option value="<%= allMatieres.get(i).getId()%>"><%= allMatieres.get(i).getNom()%></option>
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
        function getListePoketra() {
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

            for (var i = 0; i < matiereData.length; i++) {
                var row = table.insertRow(i);
                var cell = row.insertCell(0);
                cell.innerHTML = matiereData[i].nom; // Adapter cette ligne selon votre modèle Matiere
            }
        }
    </script>
</html>
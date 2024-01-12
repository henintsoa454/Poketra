/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import accessToDB.ConnectTo;

/**
 *
 * @author ITU
 */
public class FormuleFabrication {
    private int idFabricationPoketra;
    private int idMatiere;
    private int quantite;

    public int getIdFabricationPoketra() {
        return idFabricationPoketra;
    }

    public void setIdFabricationPoketra(int idFabricationPoketra) {
        this.idFabricationPoketra = idFabricationPoketra;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public FormuleFabrication(){
        
    }
    
    public FormuleFabrication(int idFabricationPoketra,int idMatiere , int quantite){
        this.setIdFabricationPoketra(idFabricationPoketra);
        this.setIdMatiere(idMatiere);
        this.setQuantite(quantite);
    }
    
    public static void inserer(int idFabricationPoketra,int idMatiere , int quantite)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into formuleFabrication(idFabricationPoketra,idMatiere,quantite) values (?,?,?)";
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idFabricationPoketra);
			preparedStatement.setInt(2, idMatiere);
			preparedStatement.setInt(3, quantite);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		}
	}
}

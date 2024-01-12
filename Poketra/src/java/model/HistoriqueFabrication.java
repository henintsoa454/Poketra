/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import accessToDB.ConnectTo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ITU
 */
public class HistoriqueFabrication {
    private int id;
    private int idFabricationPoketra;
    private int quantite;
    private Date dateFabrication;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFabricationPoketra() {
        return idFabricationPoketra;
    }

    public void setIdFabricationPoketra(int idFabricationPoketra) {
        this.idFabricationPoketra = idFabricationPoketra;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDateFabrication() {
        return dateFabrication;
    }

    public void setDateFabrication(Date dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    public HistoriqueFabrication() {
        
    }

    public HistoriqueFabrication(int id, int idFabricationPoketra, int quantite, Date dateFabrication) {
        this.setId(id);
        this.setIdFabricationPoketra(idFabricationPoketra);
        this.setQuantite(quantite);
        this.setDateFabrication(dateFabrication);
    }
    
    public static void inserer(int idFabricationPoketra, int quantite, Date dateFabrication)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into historiqueFabrication(idFabrication, quantite, dateFabrication) values (?,?,?)";
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idFabricationPoketra);
                        preparedStatement.setInt(2, quantite);
                        preparedStatement.setDate(3, dateFabrication);
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

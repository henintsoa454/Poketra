/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import accessToDB.ConnectTo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ITU
 */
public class StockMatiere {
    private int idMatiere;
    private int quantite;
    private int etat;
    private Date dateAction;

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

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Date getDateAction() {
        return dateAction;
    }

    public void setDateAction(Date dateAction) {
        this.dateAction = dateAction;
    }

    public StockMatiere() {
        
    }

    public StockMatiere(int idMatiere, int quantite, int etat, Date dateAction) {
        this.setIdMatiere(idMatiere);
        this.setQuantite(quantite);
        this.setEtat(etat);
        this.setDateAction(dateAction);
    }
     
    public static void insererPlus(int idMatiere, int quantite,Date dateAction)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into stockMatiere(idMatiere, quantite, etat, dateAction) values (?,?,?,?)";
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setInt(1, idMatiere);
			preparedStatement.setInt(2, quantite);
                        preparedStatement.setInt(3, 1);
                        preparedStatement.setDate(4, dateAction);
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
    
    public static void insererMoins(int idMatiere, int quantite,Date dateAction)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into stockMatiere(idMatiere, quantite, etat, dateAction) values (?,?,?,?)";
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setInt(1, idMatiere);
			preparedStatement.setInt(2, quantite);
                        preparedStatement.setInt(3, 2);
                        preparedStatement.setDate(4, dateAction);
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
    
    public static ArrayList<StockMatiere> getAllStock()throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from stockMatiere";
		ArrayList<StockMatiere> allStocks = new ArrayList<StockMatiere>();
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				StockMatiere stock = new StockMatiere(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getDate(4));
				allStocks.add(stock);
			}
		} catch (Exception e) {
			throw e;
		}finally {
			if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
		return allStocks;
	}
}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import accessToDB.ConnectTo;

public class Matiere {
	private int id;
	private String nom;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Matiere() {
		
	}
	
	public Matiere(int id,String nom) {
		this.setId(id);
		this.setNom(nom);
	}
	
	public static void inserer(String nom)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into matiere(nom) values (?)";
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nom);
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
	
	public static Matiere getById(int id)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from matiere where id = ?";
		Matiere matiere = null;
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				matiere = new Matiere(resultSet.getInt(1), resultSet.getString(2));
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
		return matiere;
	}
	
	public static ArrayList<Matiere> getAllMatieres()throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from matiere";
		ArrayList<Matiere> allMatieres = new ArrayList<Matiere>();
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Matiere matiere = new Matiere(resultSet.getInt(1), resultSet.getString(2));
				allMatieres.add(matiere);
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
		return allMatieres;
	}
}

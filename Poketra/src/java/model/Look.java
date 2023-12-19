package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import accessToDB.ConnectTo;

public class Look {
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
	
	public Look() {
		
	}
	
	public Look(int id,String nom) {
		this.setId(id);
		this.setNom(nom);
	}
	
	public static void inserer(String nom)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into look(nom) values (?)";
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
	
	public static Look getById(int id)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from look where id = ?";
		Look look = null;
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				look = new Look(resultSet.getInt(1), resultSet.getString(2));
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
		return look;
	}
	
	public static ArrayList<Look> getAllLooks()throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from look";
		ArrayList<Look> allLooks = new ArrayList<Look>();
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Look look = new Look(resultSet.getInt(1), resultSet.getString(2));
				allLooks.add(look);
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
		return allLooks;
	}
}

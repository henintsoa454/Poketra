/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import accessToDB.ConnectTo;

/**
 *
 * @author ITU
 */
public class Taille {
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

    public Taille(){

    }

    public Taille(int id,String nom){
        this.setId(id);
        this.setNom(nom);
    }
    
    public static void inserer(String nom)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into taille(nom) values (?)";
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
    
    public static ArrayList<Taille> getAllTailles()throws Exception{
    	Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from taille";
		ArrayList<Taille> allTailles = new ArrayList<Taille>();
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Taille taille = new Taille(resultSet.getInt(1), resultSet.getString(2));
				allTailles.add(taille);
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
		return allTailles;
    }
    
    public static Taille getById(int id)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from taille where id = ?";
		Taille taille = null;
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				taille = new Taille(resultSet.getInt(1), resultSet.getString(2));
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
		return taille;
	}
}

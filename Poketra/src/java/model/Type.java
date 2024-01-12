/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import accessToDB.ConnectTo;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ITU
 */
public class Type {
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
    
    public Type(){
        
    }
    
    public Type(int id,String nom){
        this.setId(id);
        this.setNom(nom);
    }
    
    public static ArrayList<Type> getAllTypes()throws Exception{
    	Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from type";
		ArrayList<Type> allTypes = new ArrayList<Type>();
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Type type = new Type(resultSet.getInt(1), resultSet.getString(2));
				allTypes.add(type);
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
		return allTypes;
    }
    
    public static void inserer(String nom)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into type(nom) values (?)";
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
    
    public static int lastId()throws Exception{
        Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "SELECT id FROM type ORDER BY id DESC LIMIT 1";
                int id = -1;
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getInt("id");
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
		return id;
    }
    
    public static Type getById(int id)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from type where id = ?";
		Type type = null;
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				type = new Type(resultSet.getInt(1), resultSet.getString(2));
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
		return type;
	}
    
    public double getPrix() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        double prixTotal = 0.0;
        String query = "SELECT SUM(m.prixUnitaire * f.quantite) AS total "
                    + "FROM type t "
                    + "JOIN fabricationPoketra fp ON t.id = fp.idType "
                    + "JOIN formuleFabrication f ON fp.id = f.idFabricationPoketra "
                    + "JOIN matiere m ON f.idMatiere = m.id "
                    + "WHERE t.id = ? "
                    + "GROUP BY t.id";
        try {
            connection = ConnectTo.postgreS();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, this.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                prixTotal = resultSet.getDouble("total");
            }
        } catch (Exception e) {
            throw e;
        } finally {
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

        return prixTotal;
    }
}

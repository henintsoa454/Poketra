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
public class FabricationPoketra {
    private int id;
    private int idType;
    private int idTaille;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getIdTaille() {
        return idTaille;
    }

    public void setIdTaille(int idTaille) {
        this.idTaille = idTaille;
    }
    
    public FabricationPoketra(){
        
    }
    
    public FabricationPoketra(int id, int idType, int idTaille){
        this.setId(id);
        this.setIdType(idType);
        this.setIdTaille(idTaille);
    }
    
    public static void inserer(int idType, int idTaille)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into fabricationPoketra(idType,idTaille) values (?,?)";
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idType);
			preparedStatement.setInt(2, idTaille);
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
		String query = "SELECT id FROM fabricationPoketra ORDER BY id DESC LIMIT 1";
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
    
    public static ArrayList<FabricationPoketra> getAll()throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from fabricationPoketra";
        ArrayList<FabricationPoketra> allFabricationPoketras = new ArrayList<FabricationPoketra>();
        try {
            connection = ConnectTo.postgreS();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FabricationPoketra fabricationPoketra = new FabricationPoketra(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
                allFabricationPoketras.add(fabricationPoketra);
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
        return allFabricationPoketras;
    }
}

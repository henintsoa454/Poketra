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
        private double prixUnitaire;
	
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

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
	
	public Matiere() {
		
	}
	
	public Matiere(int id,String nom,double prixUnitaire) {
		this.setId(id);
		this.setNom(nom);
                this.setPrixUnitaire(prixUnitaire);
	}
	
	public static void inserer(String nom,double prixUnitaire)throws Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into matiere(nom,prixUnitaire) values (?,?)";
		try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nom);
                        preparedStatement.setDouble(2,prixUnitaire);
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
				matiere = new Matiere(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
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
				Matiere matiere = new Matiere(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
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
        
    public static int getQuantiteTotale(int idMatiere)throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int quantiteTotale = 0;
        String sql = "SELECT quantite, etat FROM stockMatiere WHERE idMatiere = ?";
        try{
            connection = ConnectTo.postgreS();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idMatiere);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int quantite = resultSet.getInt("quantite");
                int etat = resultSet.getInt("etat");

                if (etat == 1) {
                    quantiteTotale += quantite; // Ajout
                } else if (etat == 2) {
                    quantiteTotale -= quantite; // Retrait
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        return quantiteTotale;
    }
}

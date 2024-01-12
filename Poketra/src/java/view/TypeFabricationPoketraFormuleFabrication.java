/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import accessToDB.ConnectTo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ITU
 */
public class TypeFabricationPoketraFormuleFabrication {
    private int type_id;
    private String type_nom;
    private int fabrication_id;
    private int fabrication_type_id;
    private int fabrication_taille_id;
    private int formule_fabrication_id;
    private int formule_matiere_id;
    private double formule_quantite;
    private int type_fk;
    private int fabrication_type_fk;
    private int fabrication_fk;
    private int formule_fabrication_fk;
    private int formule_matiere_fk;

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_nom() {
        return type_nom;
    }

    public void setType_nom(String type_nom) {
        this.type_nom = type_nom;
    }

    public int getFabrication_id() {
        return fabrication_id;
    }

    public void setFabrication_id(int fabrication_id) {
        this.fabrication_id = fabrication_id;
    }

    public int getFabrication_type_id() {
        return fabrication_type_id;
    }

    public void setFabrication_type_id(int fabrication_type_id) {
        this.fabrication_type_id = fabrication_type_id;
    }

    public int getFabrication_taille_id() {
        return fabrication_taille_id;
    }

    public void setFabrication_taille_id(int fabrication_taille_id) {
        this.fabrication_taille_id = fabrication_taille_id;
    }

    public int getFormule_fabrication_id() {
        return formule_fabrication_id;
    }

    public void setFormule_fabrication_id(int formule_fabrication_id) {
        this.formule_fabrication_id = formule_fabrication_id;
    }

    public int getFormule_matiere_id() {
        return formule_matiere_id;
    }

    public void setFormule_matiere_id(int formule_matiere_id) {
        this.formule_matiere_id = formule_matiere_id;
    }

    public double getFormule_quantite() {
        return formule_quantite;
    }

    public void setFormule_quantite(double formule_quantite) {
        this.formule_quantite = formule_quantite;
    }

    public int getType_fk() {
        return type_fk;
    }

    public void setType_fk(int type_fk) {
        this.type_fk = type_fk;
    }

    public int getFabrication_type_fk() {
        return fabrication_type_fk;
    }

    public void setFabrication_type_fk(int fabrication_type_fk) {
        this.fabrication_type_fk = fabrication_type_fk;
    }

    public int getFabrication_fk() {
        return fabrication_fk;
    }

    public void setFabrication_fk(int fabrication_fk) {
        this.fabrication_fk = fabrication_fk;
    }

    public int getFormule_fabrication_fk() {
        return formule_fabrication_fk;
    }

    public void setFormule_fabrication_fk(int formule_fabrication_fk) {
        this.formule_fabrication_fk = formule_fabrication_fk;
    }

    public int getFormule_matiere_fk() {
        return formule_matiere_fk;
    }

    public void setFormule_matiere_fk(int formule_matiere_fk) {
        this.formule_matiere_fk = formule_matiere_fk;
    }

    public TypeFabricationPoketraFormuleFabrication() {
        
    }

    public TypeFabricationPoketraFormuleFabrication(int type_id, String type_nom, int fabrication_id, int fabrication_type_id, int fabrication_taille_id, int formule_fabrication_id, int formule_matiere_id, double formule_quantite, int type_fk, int fabrication_type_fk, int fabrication_fk, int formule_fabrication_fk, int formule_matiere_fk) {
        this.setType_id(type_id);
        this.setType_nom(type_nom);
        this.setFabrication_id(fabrication_id);
        this.setFabrication_type_id(fabrication_type_id);
        this.setFabrication_taille_id(fabrication_taille_id);
        this.setFormule_fabrication_id(formule_fabrication_id);
        this.setFormule_matiere_id(formule_matiere_id);
        this.setFormule_quantite(formule_quantite);
        this.setType_fk(type_fk);
        this.setFabrication_type_fk(fabrication_type_fk);
        this.setFabrication_fk(fabrication_fk);
        this.setFormule_fabrication_fk(formule_fabrication_fk);
        this.setFormule_matiere_fk(formule_matiere_fk);
    }
    
    public static ArrayList<TypeFabricationPoketraFormuleFabrication> filtrerParMatiere(int matiereFk)throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM typeFabricationPoketraFormuleFabrication WHERE formule_matiere_fk = ?";
        ArrayList<TypeFabricationPoketraFormuleFabrication> results = new ArrayList<>();
        try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setInt(1,matiereFk);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
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
        return results;
    }   
    
    public static ArrayList<TypeFabricationPoketraFormuleFabrication> getAll()throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM typeFabricationPoketraFormuleFabrication";
        ArrayList<TypeFabricationPoketraFormuleFabrication> results = new ArrayList<>();
        try {
			connection = ConnectTo.postgreS();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
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
        return results;
    }
}

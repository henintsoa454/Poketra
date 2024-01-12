package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import accessToDB.ConnectTo;

public class LookMatiere {
    private int idMatiere;
    private int idLook;

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public int getIdLook() {
        return idLook;
    }

    public void setIdLook(int idLook) {
        this.idLook = idLook;
    }
    
    public LookMatiere(){
        
    }
    
    public LookMatiere(int idMatiere, int idLook){
        this.setIdMatiere(idMatiere);
        this.setIdLook(idLook);
    }
    
    public static void inserer(int idLook,int idMatiere)throws Exception{
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            String query = "insert into lookMatiere(idMatiere,idLook) values (?,?)";
            try {
                    connection = ConnectTo.postgreS();
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1, idMatiere);
                    preparedStatement.setInt(2, idLook);
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

    public static void resetLookMatiere(int idLook)throws Exception{
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            String query = "delete from lookMatiere where idLook = ?";
            try {
                    connection = ConnectTo.postgreS();
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1, idLook);
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

    public static ArrayList<Matiere> getAllMAtiereByLook(int idLook)throws Exception{
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            String query = "select * from lookMatiere where idLook = ?";
            ArrayList<Matiere> allMatieres = new ArrayList<Matiere>();
            try {
                    connection = ConnectTo.postgreS();
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1, idLook);
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        System.out.println(resultSet.getInt(1));
                        allMatieres.add(Matiere.getById(resultSet.getInt(1)));
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

    public static ArrayList<Look> getAllLookByMatiere(int idMatiere)throws Exception{
        Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            String query = "select * from lookMatiere where idMatiere = ?";
            ArrayList<Look> allLooks = new ArrayList<Look>();
            try {
                    connection = ConnectTo.postgreS();
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1, idMatiere);
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                            allLooks.add(Look.getById(resultSet.getInt(1)));
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

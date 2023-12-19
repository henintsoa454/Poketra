/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
}

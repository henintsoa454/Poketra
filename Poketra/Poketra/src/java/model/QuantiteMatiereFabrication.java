/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ITU
 */
public class QuantiteMatiereFabrication {
    private int idFabricationPoketra;
    private int idMatiere;
    private int quantite;

    public int getIdFabricationPoketra() {
        return idFabricationPoketra;
    }

    public void setIdFabricationPoketra(int idFabricationPoketra) {
        this.idFabricationPoketra = idFabricationPoketra;
    }

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
    
    public QuantiteMatiereFabrication(){
        
    }
    
    public QuantiteMatiereFabrication(int idFabricationPoketra,int idMatiere , int quantite){
        this.setIdFabricationPoketra(idFabricationPoketra);
        this.setIdMatiere(idMatiere);
        this.setQuantite(quantite);
    }
}

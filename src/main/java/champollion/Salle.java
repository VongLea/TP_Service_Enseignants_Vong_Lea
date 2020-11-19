/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

/**
 *
 * @author Léa
 */
public class Salle {
    
    private String intitule;
    private int capacite;
    
    public Salle(String intitule, int capacite) {
        this.intitule = intitule;
        this.capacite = capacite;
    }
    
    public String getIntituleSalle() {
        return this.intitule;
    }
    
    public int getCapaciteSalle() {
        return this.capacite;
    }
}

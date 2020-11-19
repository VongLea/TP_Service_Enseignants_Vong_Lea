/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.*;

/**
 *
 * @author Léa
 */
public class Intervention {
    private Date debut;
    private int duree;
    private boolean annulee = false;
    private UE matiere;
    private Salle lieu;
    private Enseignant intervenant;
    private int CM;
    private int TD;
    private int TP;
    
    public Intervention(Salle s, UE u, Enseignant e, Date deb, int duree, int CM, int TD, int TP) {
        this.lieu = s;
        this.matiere = u;
        this.intervenant = e;
        this.debut = deb;
        this.duree = duree;
        this.CM = CM;
        this.TD = TD;
        this.TP = TP;
    }
    
    public Date getDebut() {
        return new Date();
    }
    
    public int getDuree() {
        return this.duree;
    }
    
    public UE getUE() {
        return this.matiere;
    }
    
    public Salle getSalle() {
        return this.lieu;
    }
    
    public Enseignant getEnseignant() {
        return this.intervenant;
    }
    
    public int getCM() {
        return this.CM;
    }
    
    public int getTD() {
        return this.TD;
    }
    
    public int getTP() {
        return this.TP;
    }
}

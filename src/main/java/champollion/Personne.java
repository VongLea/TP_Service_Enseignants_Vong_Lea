
package champollion;


public abstract class Personne {
    private final String nom;
    private final String email;

    public Personne(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public String getNom() {
        return this.nom;
    }

    public String getEmail() {
        return this.email;
    }
    
    
}

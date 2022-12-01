package imis.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personne")
public class Personne {
    // Attributs
    @Id @GeneratedValue private int id;
    private String nom;
    private String prenom;
    private String email;

    // Constructeurs
    public Personne() {}

    public Personne(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    // Getteurs
    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getEmail() {
        return this.email;
    }
}

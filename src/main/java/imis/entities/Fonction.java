package imis.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "fonction")
public class Fonction {
    // Attributs
    @Id @GeneratedValue private int idFonction;
    private String intituleFonction;
    @OneToMany(mappedBy = "fonction") private Collection<Contact> contacts;

    // Constructeurs
    public Fonction() {}

    public Fonction(String intituleFonction) {
        this.intituleFonction = intituleFonction;
    }

    // Getteurs
    public int getIdFonction() {
        return this.idFonction;
    }

    public String getIntituleFonction() {
        return this.intituleFonction;
    }

    public Collection<Contact> getContacts() {
        return this.contacts;
    }
}

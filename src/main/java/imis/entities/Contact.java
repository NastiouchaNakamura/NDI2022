package imis.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Collection;

@Entity
public class Contact extends Personne {
    // Attributs
    private String numTelephone;
    @ManyToOne private Fonction fonction;
    @ManyToOne private Entreprise entreprise;
    @ManyToMany(mappedBy = "contactsConcernes") private Collection<Echange> echangesEffectues;

    // Constructeurs
    public Contact() {}

    public Contact(String nom, String prenom, String email, String numTelephone, Fonction fonction, Entreprise entreprise) {
        super(nom, prenom, email);
        this.numTelephone = numTelephone;
        this.fonction = fonction;
        this.entreprise = entreprise;
    }

    // Getteurs
    public String getNumTelephone() {
        return this.numTelephone;
    }

    public Fonction getFonction() {
        return this.fonction;
    }

    public Entreprise getEntreprise() {
        return this.entreprise;
    }

    public Collection<Echange> getEchangesEffectues() {
        return this.echangesEffectues;
    }
}

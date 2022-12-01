package imis.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Entreprise")
public class Entreprise {
    // Attributs
    private String nom;
    @Id private String siret;
    private String adresse;
    @ManyToMany private Collection<MotCle> motsCle;
    @OneToMany(mappedBy = "entreprise") private Collection<Vente> ventesEffectuees;
    @OneToMany(mappedBy = "entreprise") private Collection<Echange> echangesRealises;

    // Constructeurs
    public Entreprise() {}

    public Entreprise(String nom, String siret, String adresse) {
        this.nom = nom;
        this.siret = siret;
        this.adresse = adresse;
    }

    // Getteurs
    public String getNom() {
        return this.nom;
    }

    public String getSiret() {
        return this.siret;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public Collection<Vente> getVentesEffectuees() {
        return this.ventesEffectuees;
    }

    public Collection<MotCle> getMotsCle() {
        return this.motsCle;
    }

    public Collection<Echange> getEchangesRealises() {
        return this.echangesRealises;
    }
}

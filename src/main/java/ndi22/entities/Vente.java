package ndi22.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Vente")
public class Vente {
    // Attributs
    @Id @GeneratedValue private int id;
    private Date dateVente;
    private int montant;
    private String nature;
    @ManyToOne private Entreprise entreprise;

    // Constructeurs
    public Vente() {}

    public Vente(Date dateVente, int montant, String nature, Entreprise entreprise) {
        this.dateVente = dateVente;
        this.montant = montant;
        this.nature = nature;
        this.entreprise = entreprise;
    }

    // Getteurs
    public int getId() {
        return this.id;
    }

    public Date getDateVente() {
        return this.dateVente;
    }

    public int getMontant() {
        return this.montant;
    }

    public String getNature() {
        return this.nature;
    }

    public Entreprise getEntreprise() {
        return this.entreprise;
    }
}

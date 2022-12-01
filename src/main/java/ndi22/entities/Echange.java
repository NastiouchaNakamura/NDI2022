package ndi22.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "Echange")
public class Echange {
    // Attributs
    @Id @GeneratedValue private int id;
    private Date dateEchange;
    private String compteRendu;
    @ManyToMany private Collection<Employe> employesConcernes;
    @ManyToMany private Collection<Contact> contactsConcernes;
    @ManyToOne private Entreprise entreprise;

    // Constructeurs
    public Echange() {}

    public Echange(Date dateEchange, String compteRendu, Entreprise entreprise) {
        this.dateEchange = dateEchange;
        this.compteRendu = compteRendu;
        this.entreprise = entreprise;
    }

    // Getteurs
    public int getId() {
        return this.id;
    }

    public Date getDateEchange() {
        return this.dateEchange;
    }

    public Collection<Employe> getEmployesConcernes() {
        return this.employesConcernes;
    }

    public Collection<Contact> getContactsConcernes() {
        return this.contactsConcernes;
    }

    public Entreprise getEntreprise() {
        return this.entreprise;
    }
}

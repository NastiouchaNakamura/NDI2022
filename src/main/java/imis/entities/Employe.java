package imis.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Collection;

@Entity
public class Employe extends Personne {
    // Attributs
    @ManyToOne private ServiceInterne serviceInterne;
    @ManyToMany(mappedBy = "employesConcernes") private Collection<Echange> echangesEffectues;

    // Constructeurs
    public Employe() {}

    public Employe(String nom, String prenom, String email, ServiceInterne serviceInterne) {
        super(nom, prenom, email);
        this.serviceInterne = serviceInterne;
    }

    // Getteurs
    public ServiceInterne getServiceInterne() {
        return this.serviceInterne;
    }

    public Collection<Echange> getEchangesEffectues() {
        return this.echangesEffectues;
    }
}

package ndi22.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ServiceInterne")
public class ServiceInterne {
    // Attributs
    @Id @GeneratedValue private int id;
    private String nomSI;
    @OneToMany(mappedBy = "serviceInterne") Collection<Employe> employe;
}

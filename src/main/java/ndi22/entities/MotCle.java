package ndi22.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MotCle")
public class MotCle {
    // Attributs
    @Id @GeneratedValue private int id;
    private String motCle;

    // Constructeurs
    public MotCle() {}

    public MotCle(String motCle) {
        this.motCle = motCle;
    }

    // Getteurs
    public int getId() {
        return this.id;
    }

    public String getMotCle() {
        return this.motCle;
    }
}

package ndi22.services;

import ndi22.entities.Contact;
import ndi22.entities.Entreprise;
import ndi22.entities.Fonction;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createEntreprise(String nom, String siret, String adresse) {
        Entreprise entreprise = new Entreprise(nom, siret, adresse);
        em.persist(entreprise);
    }

    @Transactional
    public void createFonction(String intituleFonction) {
        Fonction fonction = new Fonction(intituleFonction);
        em.persist(fonction);
    }

    public List<Entreprise> findAllEntreprises() {
        return em.createQuery("SELECT e FROM Entreprise e").getResultList();
    }

    public List<Entreprise> findAllFonctions() {
        return em.createQuery("SELECT f FROM Fonction f").getResultList();
    }

    @Transactional
    public void createContact(String nom, String prenom, String email, String telephone, String siretEntreprise, int idFonction) {
        Entreprise entreprise = em.find(Entreprise.class, siretEntreprise);
        Fonction fonction = em.find(Fonction.class, idFonction);
        Contact contact = new Contact(nom, prenom, email, telephone, fonction, entreprise);
        em.persist(contact);
    }

    public Entreprise entrepriseAvecLePlusDeContacts() {
        return null;
        // return (Entreprise) em.createQuery("SELECT * FROM (SELECT ENTREPRISE_SIRET, COUNT(*) AS CNT FROM PERSONNE GROUP BY ENTREPRISE_SIRET)").getSingleResult();
    }

    public List<Entreprise> findByMotCle(String motCle) {
        //return em.createQuery("SELECT e FROM Entreprise e WHERE e.motsCle=:id").getResultList();

        /*
        Query q = em.createNamedQuery("imis.entities.Entreprise.motsCle");
        q.setParameter("id", motCle);
        return q.getResultList();

         */

        return null;
    }
}

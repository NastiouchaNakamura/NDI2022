package ndi22.controllers;

import ndi22.services.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class Controleur {
    @Autowired
    Facade facade;

    @RequestMapping("")
    public String root() {
        return "hello";
    }

    @GetMapping("createEntreprise")
    public String createEntrepriseGet() {
        return "createEntreprise";
    }

    @PostMapping("createEntreprise")
    public String createEntreprisePost(@RequestParam String nom, @RequestParam String siret, @RequestParam String adresse) {
        facade.createEntreprise(nom, siret, adresse);
        return "hello";
    }

    @GetMapping("createFonction")
    public String createFonctionGet() {
        return "createFonction";
    }

    @PostMapping("createFonction")
    public String createFonctionPost(@RequestParam String intitule) {
        this.facade.createFonction(intitule);
        return "hello";
    }

    @GetMapping("createContact")
    public String createContactGet(Model model) {
        model.addAttribute("entreprises", this.facade.findAllEntreprises());
        model.addAttribute("fonctions", this.facade.findAllFonctions());
        return "createContact";
    }

    @PostMapping("createContact")
    public String createContactPost(@RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String telephone, @RequestParam String entreprise, @RequestParam int fonction) {
        this.facade.createContact(nom, prenom, email, telephone, entreprise, fonction);
        return "hello";
    }

    @GetMapping("plusContact")
    public String plusContact(Model model) {
        model.addAttribute("e", this.facade.entrepriseAvecLePlusDeContacts());
        return "plusContact";
    }

    @GetMapping("motcle")
    public String parMotCle(@RequestParam String motcle, Model model) {
        model.addAttribute("motcle", motcle);
        model.addAttribute("entreprises", facade.findByMotCle(motcle));
        return "entreprises";
    }
}

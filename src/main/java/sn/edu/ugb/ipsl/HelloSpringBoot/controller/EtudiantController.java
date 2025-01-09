package sn.edu.ugb.ipsl.HelloSpringBoot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.edu.ugb.ipsl.HelloSpringBoot.entities.Etudiant;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @GetMapping
    public List<Etudiant> getEtudiants () {
        List<Etudiant> etudiants = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(i);
            etudiant.setNom("nom" + i);
            etudiant.setPrenom("prenom" + i);
            etudiants.add(etudiant);
        }
        return etudiants;
    }
}

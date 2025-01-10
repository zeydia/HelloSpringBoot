package sn.edu.ugb.ipsl.HelloSpringBoot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sn.edu.ugb.ipsl.HelloSpringBoot.entities.Etudiant;
import sn.edu.ugb.ipsl.HelloSpringBoot.services.EtudiantService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    public EtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> getEtudiants () {
       // List<Etudiant> etudiants = new ArrayList<>();
        List<Etudiant> etudiants1 = etudiantService.getEtudiants();

//        for (int i = 0; i < 10; i++) {
//            Etudiant etudiant = new Etudiant();
//            etudiant.setId(i);
//            etudiant.setNom("nom" + i);
//            etudiant.setPrenom("prenom" + i);
//            etudiants.add(etudiant);
//        }

        return etudiants1;
    }

    @GetMapping("/{id}")
    public ResponseEntity getEtudiantById (@PathVariable Integer id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);

        if (etudiant == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(etudiant);
    }

    @PutMapping
    public ResponseEntity saveEtudiant (@RequestBody Etudiant etudiant) {

        if (etudiant.getPrenom() == null) {
            return ResponseEntity.status(450).body("Prenom obligatoire");
        }
        if (etudiant.getPrenom().isBlank()) {
            return ResponseEntity.status(451).body("Prenom doit pas etre vide");
        }
        if (etudiant.getNom() == null) {
            return ResponseEntity.status(450).body("Nom obligatoire");
        }
        if (etudiant.getNom().isBlank()) {
            return ResponseEntity.status(451).body("Nom doit pas etre vide");
        }

        etudiantService.saveEtudiant(etudiant);
        return ResponseEntity.status(201).body(etudiant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEtudiant (@PathVariable Integer id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);

        if (etudiant == null) {
            return ResponseEntity.status(401).body("Etudiant"+id+" n'existe pas");
        }
        etudiantService.deleteEtudiantById(etudiant);
        return ResponseEntity.status(200).build();
    }
}

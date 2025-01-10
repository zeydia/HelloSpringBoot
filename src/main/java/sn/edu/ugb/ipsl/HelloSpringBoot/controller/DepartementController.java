package sn.edu.ugb.ipsl.HelloSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.HelloSpringBoot.entities.Departement;
import sn.edu.ugb.ipsl.HelloSpringBoot.services.DepartementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departement")
public class DepartementController {

    @Autowired
    public DepartementService departementService;

    @GetMapping
    public List<Departement> getAllDepartements() {

        List<Departement> departements1 = departementService.getAllDepartements();

        System.out.println("La liste des departements: "+departements1);

        return departements1;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Departement>> getDepartementById (@PathVariable Integer id) {
        Optional<Departement> departement = departementService.getDepartementById(Long.valueOf(id));

        if (departement.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(departement);
    }

    @PutMapping
    public ResponseEntity saveDepartement (@RequestBody Departement departement) {

        if (departement.getNom() == null) {
            return ResponseEntity.status(450).body("Nom departement obligatoire");
        }
        if (departement.getNom().isBlank()) {
            return ResponseEntity.status(451).body("Nom departement doit pas etre vide");
        }
        if (departement.getDescription() == null) {
            return ResponseEntity.status(450).body("description obligatoire");
        }
        if (departement.getDescription().isBlank()) {
            return ResponseEntity.status(451).body("La description doit pas etre vide");
        }

        departementService.saveDepartement(departement);
        return ResponseEntity.status(201).body(departement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartement (@PathVariable Integer id) {
        Optional<Departement> departement = departementService.getDepartementById(Long.valueOf(id));

        if (departement.isEmpty()) {
            return ResponseEntity.status(401).body("Le departement"+id+" n'existe pas");
        }
        departementService.deleteDepartementById(Long.valueOf(id));
        return ResponseEntity.status(200).build();
    }
}

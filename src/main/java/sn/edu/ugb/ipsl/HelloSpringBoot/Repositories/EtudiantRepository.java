package sn.edu.ugb.ipsl.HelloSpringBoot.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import sn.edu.ugb.ipsl.HelloSpringBoot.entities.Etudiant;

import java.util.List;

public interface EtudiantRepository {

    default void saveEtudiant(Etudiant etudiant) {}

    default Etudiant getEtudiantById(Integer id) { return null; }

    default List<Etudiant> getAllEtudiants() {  return null; }

    default  void deleteEtudiant(Etudiant etudiant) {}
}

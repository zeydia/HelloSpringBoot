package sn.edu.ugb.ipsl.HelloSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.HelloSpringBoot.Repositories.EtudiantRepository;
import sn.edu.ugb.ipsl.HelloSpringBoot.entities.Etudiant;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> getEtudiants() {
        return etudiantRepository.getAllEtudiants();
    }

    public  Etudiant getEtudiantById(Integer id) {
        return  etudiantRepository.getEtudiantById(id);
    }

    public void saveEtudiant(Etudiant etudiant) {
        etudiantRepository.saveEtudiant(etudiant);
    }

    public void deleteEtudiantById(Etudiant etudiant) {
        etudiantRepository.deleteEtudiant(etudiant);
    }
}

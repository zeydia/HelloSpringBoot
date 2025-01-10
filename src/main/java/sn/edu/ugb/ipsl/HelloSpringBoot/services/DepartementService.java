package sn.edu.ugb.ipsl.HelloSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.HelloSpringBoot.Repositories.DepartementRepository;
import sn.edu.ugb.ipsl.HelloSpringBoot.entities.Departement;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    public Optional<Departement> getDepartementById(Long id) {
        return departementRepository.findById(id);
    }


    public void saveDepartement(Departement departement) {
        departementRepository.save(departement);
    }

    public void deleteDepartementById(Long id) {
        departementRepository.deleteById(id);
    }
}

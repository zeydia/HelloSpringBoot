package sn.edu.ugb.ipsl.HelloSpringBoot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.HelloSpringBoot.entities.Departement;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Long> {


}

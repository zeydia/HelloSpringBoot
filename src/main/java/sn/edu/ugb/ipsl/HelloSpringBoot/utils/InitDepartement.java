package sn.edu.ugb.ipsl.HelloSpringBoot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.edu.ugb.ipsl.HelloSpringBoot.Repositories.DepartementRepository;
import sn.edu.ugb.ipsl.HelloSpringBoot.entities.Departement;

@Component
public class InitDepartement implements CommandLineRunner {


    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("###Initialisation departement");
        Departement d1 = new Departement();
        d1.setNom("GIT");
        d1.setDescription("Genie Informatique et Telecom");


        Departement d2 = Departement.builder()
                .nom("Gec")
                .description("Genie Civil")
                .build();

        departementRepository.save(d1);
        departementRepository.save(d2);
    }
}
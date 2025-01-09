package sn.edu.ugb.ipsl.HelloSpringBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Etudiant {

    @Id
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;

}

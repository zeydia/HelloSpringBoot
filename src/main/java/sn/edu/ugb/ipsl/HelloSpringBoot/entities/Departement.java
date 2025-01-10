package sn.edu.ugb.ipsl.HelloSpringBoot.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Departement")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false)
    private String nom;
    private String description;

    @PrePersist
    @PreUpdate
    public void trimField() {
        System.out.println("Trim Field departement"+ nom);
        if (description != null) {
            description = description.trim();
        }
        if (nom != null) {
            nom = nom.trim();
        }
    }
}

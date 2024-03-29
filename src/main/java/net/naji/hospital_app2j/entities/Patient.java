package net.naji.hospital_app2j.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Table(name = "PATIENTS")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 55)
    private String nom;
    @Column(length = 55)
    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private int score;
    private boolean malade;

}

package tn.examen.spring.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEvenement;
    String nomEvenement;
    long nbPlaceRestants;
    LocalDate dateEvenement;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Categorie> categories = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="evenement")
    private Set<Ticket> Tickets = new HashSet<>();
}

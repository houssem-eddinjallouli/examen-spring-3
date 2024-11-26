package tn.examen.spring.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Internaute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idInternaute;
    String identifiant;
    @Enumerated(EnumType.STRING)
    TrancheAge trancheAge;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="internaute")
    private Set<Ticket> Tickets = new HashSet<>();
}


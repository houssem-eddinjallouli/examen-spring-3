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
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCategorie;
    String codeCategorie;
    String nomCategorie;

    @ManyToMany(mappedBy="categories", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Evenement> evenements = new HashSet<>();
}

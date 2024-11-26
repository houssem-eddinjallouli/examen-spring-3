package tn.examen.spring.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idTicket;
    String codeTicket;
    Double prixTicket;
    @Enumerated(EnumType.STRING)
    TypeTicket typeTicket;


    @ManyToOne
    Evenement evenement;


    @ManyToOne
    Internaute internaute;
}


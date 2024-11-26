package tn.examen.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.examen.spring.entities.Evenement;

import java.time.LocalDate;
import java.util.List;

public interface EvenementRepo extends JpaRepository<Evenement,Long> {
}

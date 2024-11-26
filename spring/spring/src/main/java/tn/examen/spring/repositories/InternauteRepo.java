package tn.examen.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.examen.spring.entities.Internaute;
import tn.examen.spring.entities.TrancheAge;

import java.time.LocalDate;
import java.util.List;

public interface InternauteRepo extends JpaRepository<Internaute,Long> {
    @Query("SELECT COUNT(DISTINCT t.internaute.idInternaute) " +
            "FROM Ticket t " +
            "WHERE t.internaute.trancheAge = :trancheAge " +
            "AND t.evenement.dateEvenement BETWEEN :dateMin AND :dateMax")
    Long countInternautesByTrancheAgeAndDateEvenement(TrancheAge trancheAge, LocalDate dateMin, LocalDate dateMax);

}

package tn.examen.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.examen.spring.entities.Ticket;
import tn.examen.spring.entities.TypeTicket;

public interface TicketRepo extends JpaRepository<Ticket,Long> {
    @Query("SELECT SUM(t.prixTicket) " +
            "FROM Ticket t " +
            "WHERE t.evenement.nomEvenement = :nomEvt " +
            "AND t.typeTicket = :typeTicket")
    Double sumMontantByEvenementAndTypeTicket(String nomEvt, TypeTicket typeTicket);
}

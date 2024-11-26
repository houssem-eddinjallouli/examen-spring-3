package tn.examen.spring.services;

import tn.examen.spring.entities.*;

import java.time.LocalDate;
import java.util.List;

public interface IExamenService {

    Internaute ajouterInternaute(Internaute internaute);
    Evenement ajouterEvenement(Evenement evenement);
    void listeEvenementsParCategorie();
    List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(List<Ticket> tickets, Long idEvenement, Long idinternaute );
    Long nbinternauteParTrancheAgeEtDateEvenement (TrancheAge trancheAge, LocalDate dateMin, LocalDate dateMax);
    Double montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket);
    String internauteLePlusActif();

}

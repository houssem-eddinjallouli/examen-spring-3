package tn.examen.spring.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.examen.spring.entities.*;
import tn.examen.spring.repositories.CategorieRepo;
import tn.examen.spring.repositories.EvenementRepo;
import tn.examen.spring.repositories.InternauteRepo;
import tn.examen.spring.repositories.TicketRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service
@Slf4j
@AllArgsConstructor
public class ExamenServiceImp implements IExamenService{
    CategorieRepo categorieRepo;
    EvenementRepo evenementRepo;
    InternauteRepo internauteRepo;
    TicketRepo ticketRepo;


        @Override
        public Internaute ajouterInternaute(Internaute internaute) {
            return internauteRepo.save(internaute);
        }

    @Override
    public Evenement ajouterEvenement(Evenement evenement) {
        Set<Categorie> categories = evenement.getCategories();
        for (Categorie c : categories)
            evenement.getCategories().add(c);
        return evenementRepo.save(evenement);
    }

    @Scheduled(fixedRate = 15000)
    //@Scheduled(cron = "*/15 * * * * *")
    @Override
    public void listeEvenementsParCategorie() {
        List<Categorie> categories = categorieRepo.findAll();
        for (Categorie c: categories) {
            log.info("Categorie "+ c.getNomCategorie());
            for (Evenement e : c.getEvenements())
                log.info("Evenement " + e.getNomEvenement() + " planifieé le " + e.getDateEvenement());

        }


    }

    @Override
    @Transactional
    public List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(List<Ticket> tickets, Long idEvenement, Long idinternaute) {
        Evenement evenement = evenementRepo.findById(idEvenement).orElse(null);
        Internaute internaute = internauteRepo.findById(idinternaute).orElse(null);

        for (Ticket t : tickets ){
            if (evenement.getNbPlaceRestants() > 0) {
                t.setEvenement(evenement);
                evenement.setNbPlaceRestants(evenement.getNbPlaceRestants() - 1);
                t.setInternaute(internaute);
                ticketRepo.save(t);
//                evenementRepo.save(evenement);
            }
            else
                throw new java.lang.UnsupportedOperationException("nombre de places demandées indisponibe");
        }

        //ticketRepo.saveAll(tickets);
        return tickets;
    }

    @Override
    public Long nbinternauteParTrancheAgeEtDateEvenement(TrancheAge trancheAge, LocalDate dateMin, LocalDate dateMax) {

        return internauteRepo.countInternautesByTrancheAgeAndDateEvenement(trancheAge,dateMin,dateMax);
    }

    @Override
    public Double montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket) {
        return ticketRepo.sumMontantByEvenementAndTypeTicket(nomEvt, typeTicket);
    }

    @Override
    public String internauteLePlusActif() {
        List<Internaute> internautes = internauteRepo.findAll();
        int max= 0;
        String identifiantleplus="";
        for (Internaute i : internautes)
        {
             int nbrt=0;
            //i.getTickets().stream().count();
            for (Ticket t : i .getTickets())
                nbrt ++;
            if (max < nbrt) {
                max=nbrt;
                identifiantleplus = i.getIdentifiant();
            }

        }
        return identifiantleplus;
    }
}

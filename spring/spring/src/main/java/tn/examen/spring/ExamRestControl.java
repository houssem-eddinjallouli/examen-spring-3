package tn.examen.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.examen.spring.entities.Evenement;
import tn.examen.spring.entities.Internaute;
import tn.examen.spring.entities.Ticket;
import tn.examen.spring.services.IExamenService;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamRestControl {
    @Autowired
    IExamenService iExamenService;

    @PostMapping("/addi")
    public Internaute ajouterInternaute(@RequestBody Internaute internaute) {
        return iExamenService.ajouterInternaute(internaute);
    }


    @PostMapping ("/adde")
    public Evenement ajouterEvenement(@RequestBody Evenement evenement) {
        return iExamenService.ajouterEvenement(evenement);
    }


    @PostMapping("/addt/{ide}/{idi}")
    public List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(@RequestBody List<Ticket> tickets,@PathVariable("ide") Long idEvenement,@PathVariable("idi") Long idinternaute) {

        return iExamenService.ajouterTicketsEtAffecterAEvenementEtInternaute(tickets,idEvenement,idinternaute);

    }

    @GetMapping("/leplus")
    public String internauteLePlusActif() {
        return iExamenService.internauteLePlusActif();
    }
    }

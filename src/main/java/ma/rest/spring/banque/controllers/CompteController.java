package ma.rest.spring.banque.controllers;

import ma.rest.spring.banque.entities.Compte;
import ma.rest.spring.banque.repositories.CompteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banque")
@CrossOrigin(origins = "http://localhost:3000")
public class CompteController {

    private final CompteRepository compteRepository;

    public CompteController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @GetMapping("/comptes")
    public List<Compte> getAll() {
        return compteRepository.findAll();
    }

    @PostMapping("/comptes")
    public Compte create(@RequestBody Compte compte) {
        System.out.println("Reçu du front : " + compte);
        return compteRepository.save(compte);
    }


}

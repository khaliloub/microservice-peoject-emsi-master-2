package com.project.microservicecommandes.controllers;

import com.project.microservicecommandes.dao.CommandeDao;
import com.project.microservicecommandes.model.Commande;
import com.project.microservicecommandes.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService service;

    @GetMapping
    public List<Commande> getAllcommandes(){
        return service.findAll();
    }

    @PostMapping
    public String createcommande(@RequestBody Commande commande){
        service.save(commande);
        return "commande added sucessfuly";
    }
    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandbyId(@PathVariable int id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public String deleteCommande(@PathVariable int id){
        service.deleteById(id);
        return "commande id: " + id + " deleted successfully";
    }
}

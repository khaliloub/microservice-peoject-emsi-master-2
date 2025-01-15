package com.project.microservicecommandes.controllers;

import com.project.microservicecommandes.configuration.CommandeConfig;
import com.project.microservicecommandes.model.Commande;
import com.project.microservicecommandes.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/config")
public class CommandeConfigController {

        @Autowired
        private CommandeConfig commandeConfig;

        @Autowired
        private CommandeService commandeService;

        @GetMapping("/last-days")
        public List<Commande> getCommandesLastDays() {
                int lastDays = commandeConfig.getCommandesLast(); // Get the configured number of days
                LocalDate startDate = LocalDate.now().minusDays(lastDays); // Calculate the start date
                return commandeService.findCommandesFromDate(startDate); // Fetch commandes from the database
        }
}


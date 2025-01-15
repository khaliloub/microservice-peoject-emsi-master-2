package com.project.microservicecommandes.dao;

import com.project.microservicecommandes.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CommandeDao extends JpaRepository<Commande,Integer> {
    @Query("SELECT c FROM Commande c WHERE c.date >= :startDate")
    List<Commande> findCommandesFromDate(LocalDate startDate);
}

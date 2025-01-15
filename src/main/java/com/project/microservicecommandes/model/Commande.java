package com.project.microservicecommandes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Commande {
    @Id
    @GeneratedValue
    private int id;

    private String description;

    private int quantité;

    @DateTimeFormat
    private LocalDate date;

    private double montant;



}

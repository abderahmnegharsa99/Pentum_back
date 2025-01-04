package tn.esprit.tradingback.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import tn.esprit.tradingback.Entities.Enums.TypeOrdre;

import java.util.Date;
@Getter
@Setter
public class OrdreDTO {

    private String symboleProduit;
    private String typeProduit;
    private Float prix;
    private Long quantite;
    @Enumerated(EnumType.STRING)
    private TypeOrdre typeOrdre;
    private Long idPortfeuille; // ID uniquement
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    // Getters et Setters
}

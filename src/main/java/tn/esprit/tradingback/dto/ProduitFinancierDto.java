package tn.esprit.tradingback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

//@NoArgsConstructor

public class ProduitFinancierDto {
    private String symbole;
    private String type; // "Action" ou "Obligation"
    private Float prixActuel; // Prix de clôture
    private Float prixOuverture; // Prix d'ouverture
    private Float prixHaut; // Prix le plus haut
    private Float prixBas; // Prix le plus bas
    private Long volume; // Volume d'échange
    private String derniereMiseAJour; // Date et heure de la donnée
    private String exchange; // Nouveau champ pour le marché (ex: NASDAQ)
    private String currency;

    public ProduitFinancierDto(String symbole, String type, Float prixActuel, Float prixOuverture,
                               Float prixHaut, Float prixBas, Long volume, String derniereMiseAJour,String exchange, String currency) {
        this.symbole = symbole;
        this.type = type;
        this.prixActuel = prixActuel;
        this.prixOuverture = prixOuverture;
        this.prixHaut = prixHaut;
        this.prixBas = prixBas;
        this.volume = volume;
        this.derniereMiseAJour = derniereMiseAJour;
        this.exchange = exchange;
        this.currency = currency;

    }
}

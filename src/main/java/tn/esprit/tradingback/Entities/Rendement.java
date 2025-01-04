package tn.esprit.tradingback.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rendement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portefeuille_id", nullable = false)
    private Portfeuille portefeuille; // Le portefeuille auquel appartient ce rendement

    private String symboleProduit; // Symbole du produit financier (ex : MSFT, AAPL)

    private Float rendement; // Rendement en pourcentage

    private Float valeurActuelle; // Valeur actuelle totale pour ce produit

    private Float profitOuPerte; // Profit ou perte pour ce produit

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCalcul; // Date et heure du calcul
}


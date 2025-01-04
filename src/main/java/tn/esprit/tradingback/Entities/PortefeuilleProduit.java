package tn.esprit.tradingback.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PortefeuilleProduit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPr;

    private String symboleProduit; // Symbole du produit financier (ex: AAPL pour une action ou OBL123 pour une obligation)
    private String typeProduit; // "Action" ou "Obligation"
    private Long quantite; // Quantité que l'utilisateur possède
    private Float prixAchat; // Prix d'achat du produit financier

    @ManyToOne
    @JoinColumn(name = "portefeuille_id")
    private Portfeuille portefeuille;

}

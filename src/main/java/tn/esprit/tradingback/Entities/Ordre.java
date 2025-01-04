package tn.esprit.tradingback.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.tradingback.Entities.Enums.TypeOrdre;

import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Ordre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdre;
    private String symboleProduit;
    private String typeProduit;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private Float  prix;
    private Long quantite;
    private String etat; // "EN_ATTENTE", "ACCEPTE", "REFUSE"
    @Enumerated(EnumType.STRING)
    private TypeOrdre typeOrdre;

    @ManyToOne
    @JoinColumn(name = "portfeuille_id")//,nullable = false)
    @JsonBackReference
    private Portfeuille portfeuille;
    @ManyToOne
    @JoinColumn(name = "marche_id")
    private Marche marche;

}
package tn.esprit.tradingback.Entities;

import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


//@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
//@Table(name = "COMPTE")



public class Compte implements Serializable {
    @Id
    @Column(name ="numCompte")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long numCompte;
    private Float solde;
    private String pays;
    private String rib;
    private String iban;
    private String nomBanque;
    @Temporal (TemporalType.DATE)
    private Date dateOuverture;
    private boolean state;
    @JsonIgnore
    @ManyToOne
    private User utilisateurC;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "comptesTransaction")
    private Set<Transaction> Transactions ;
}

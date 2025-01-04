package tn.esprit.tradingback.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Portfeuille implements Serializable {
    @Id
    @Column(name ="idPortfeuille")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPortfeuille;
    @Temporal (TemporalType.DATE)
    private Date dateOuverture;
    private Float  solde;
    //@JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idU")
    private User user;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "portfeuille", orphanRemoval = true)
    @JsonManagedReference
    private Set<Ordre> ordres;
}

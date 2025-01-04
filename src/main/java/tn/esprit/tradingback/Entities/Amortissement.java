package tn.esprit.tradingback.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Amortissement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAmortissement;
    private Float num;
    private Date dateEcheance;
    private Float montantEcheance;
    private Float capitalRembourse;
    private Float capitalRestantDu;
    private Float montant;
    private String dateAmortissement;

}

package tn.esprit.tradingback.Auth;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistreRequest {
    String nom;
    String prenom;
    Long numCin;
    Date dateDeNaissance;
    String paysDeNaissance;
    String nationalite;
    String adress;
    Float codePostal;
    Float contact;
    String mail;
    String motDePasse;

    // Champs ajoutés pour le compte bancaire
    Long numCompte;  // Numéro du compte bancaire
    String nomBanque;
}

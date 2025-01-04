package tn.esprit.tradingback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tradingback.Entities.PortefeuilleProduit;
import tn.esprit.tradingback.Entities.Portfeuille;
import tn.esprit.tradingback.Entities.Rendement;
import tn.esprit.tradingback.Repositories.PortefeuilleProduitRepository;
import tn.esprit.tradingback.Repositories.PortefeuilleRepository;
import tn.esprit.tradingback.Repositories.RendementRepository;

import java.text.DecimalFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PortfeuilleService {

    //    @Autowired
    //   private PortefeuilleRepository portefeuilleRepository;

    //  @Autowired
    //   private PortefeuilleProduitRepository portefeuilleProduitRepository;

    //   @Autowired
    //   private RendementRepository rendementRepository;

    //    @Autowired
    //   private YahooFinanceService yahooFinanceService;

    //   private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");

    // Récupérer un portefeuille par ID
    //    public Portfeuille getPortefeuilleById(Long id) {
    //      return portefeuilleRepository.findById(id)
    //            .orElseThrow(() -> new RuntimeException("Portefeuille introuvable pour l'ID : " + id));
    //    }

    // Calcul du rendement par produit
    //   public Map<String, String> calculerRendementsParPortefeuilleId(Long portefeuilleId) {
    //      List<PortefeuilleProduit> produits = portefeuilleProduitRepository.findByPortefeuilleId(portefeuilleId);
    //    Map<String, String> rendements = new HashMap<>();

    //     for (PortefeuilleProduit produit : produits) {
    //        float prixActuel = yahooFinanceService.getPrixActuel(produit.getSymboleProduit());
    //        float rendement = ((prixActuel - produit.getPrixAchat()) / produit.getPrixAchat()) * 100;
    //       rendements.put(produit.getSymboleProduit(), formatPercentage(rendement));
    //    }

    //     return rendements;
    //   }

    // Calcul de la valeur totale actuelle par produit
    //   public Map<String, Float> calculerValeursTotales(Long portefeuilleId) {
    //   List<PortefeuilleProduit> produits = portefeuilleProduitRepository.findByPortefeuilleId(portefeuilleId);
    //    Map<String, Float> valeursTotales = new HashMap<>();

    //     for (PortefeuilleProduit produit : produits) {
    //      float prixActuel = yahooFinanceService.getPrixActuel(produit.getSymboleProduit());
    //       float valeurTotale = produit.getQuantite() * prixActuel;
    //        valeursTotales.put(produit.getSymboleProduit(), valeurTotale);
    //   }

    //     return valeursTotales;
    //   }

    // Calcul du profit ou perte par produit
    //  public Map<String, Float> calculerProfitOuPerte(Long portefeuilleId) {
    //    List<PortefeuilleProduit> produits = portefeuilleProduitRepository.findByPortefeuilleId(portefeuilleId);
    //     Map<String, Float> profitsOuPertes = new HashMap<>();

    //     for (PortefeuilleProduit produit : produits) {
    //       float prixActuel = yahooFinanceService.getPrixActuel(produit.getSymboleProduit());
    //       float profitOuPerte = (prixActuel - produit.getPrixAchat()) * produit.getQuantite();
    //       profitsOuPertes.put(produit.getSymboleProduit(), profitOuPerte);
    //   }

    //    return profitsOuPertes;
    //   }

    // Calcul du rendement global du portefeuille
    //   public float calculerRendementGlobal(Long portefeuilleId) {
    //   List<PortefeuilleProduit> produits = portefeuilleProduitRepository.findByPortefeuilleId(portefeuilleId);
    //    float valeurInitialeTotale = 0;
    //    float valeurActuelleTotale = 0;

    //    for (PortefeuilleProduit produit : produits) {
    //       float prixActuel = yahooFinanceService.getPrixActuel(produit.getSymboleProduit());
    //       valeurInitialeTotale += produit.getPrixAchat() * produit.getQuantite();
    //       valeurActuelleTotale += prixActuel * produit.getQuantite();
    //    }

    //    if (valeurInitialeTotale == 0) {
    //       throw new ArithmeticException("La valeur initiale totale ne peut pas être zéro.");
    //    }

    //    return ((valeurActuelleTotale - valeurInitialeTotale) / valeurInitialeTotale) * 100;
    //    }

    // Sauvegarde des rendements
    //   public void sauvegarderRendements(Long portefeuilleId) {
    //    Portfeuille portefeuille = getPortefeuilleById(portefeuilleId);
    //   List<PortefeuilleProduit> produits = portefeuilleProduitRepository.findByPortefeuilleId(portefeuilleId);

    //     for (PortefeuilleProduit produit : produits) {
    //       float prixActuel = yahooFinanceService.getPrixActuel(produit.getSymboleProduit());
    //        float rendement = ((prixActuel - produit.getPrixAchat()) / produit.getPrixAchat()) * 100;
    //       float valeurActuelle = prixActuel * produit.getQuantite();
    //       float profitOuPerte = (prixActuel - produit.getPrixAchat()) * produit.getQuantite();

            // Créer un nouvel objet Rendement
    //       Rendement rendementEntity = new Rendement();
    //       rendementEntity.setPortefeuille(portefeuille);
    //       rendementEntity.setSymboleProduit(produit.getSymboleProduit());
    //       rendementEntity.setRendement(rendement);
    //       rendementEntity.setValeurActuelle(valeurActuelle);
    //      rendementEntity.setProfitOuPerte(profitOuPerte);
    //       rendementEntity.setDateCalcul(new Date());

    //     // Sauvegarder dans la base de données
    //       rendementRepository.save(rendementEntity);
    //   }
    //   }

    //   public float calculerRatioGainPerte(Long portefeuilleId) {
    //     List<PortefeuilleProduit> produits = portefeuilleProduitRepository.findByPortefeuilleId(portefeuilleId);

    //    int produitsEnGain = 0;
    //     int produitsEnPerte = 0;

    //    for (PortefeuilleProduit produit : produits) {
    //       float prixActuel = yahooFinanceService.getPrixActuel(produit.getSymboleProduit());
    //      float profitOuPerte = (prixActuel - produit.getPrixAchat()) * produit.getQuantite();

    //      if (profitOuPerte > 0) {
    //          produitsEnGain++;
    //     } else if (profitOuPerte < 0) {
    //          produitsEnPerte++;
    //      }
    //   }

    //   if (produitsEnPerte == 0) {
    //      return produitsEnGain; // Évite une division par zéro si aucun produit en perte
    //   }

    //   return (float) produitsEnGain / produitsEnPerte;
    //  }

    //   public Map<String, Float> calculerPoidsProduits(Long portefeuilleId) {
    //     List<PortefeuilleProduit> produits = portefeuilleProduitRepository.findByPortefeuilleId(portefeuilleId);
    //     Map<String, Float> poidsProduits = new HashMap<>();

    //   float valeurTotalePortefeuille = 0;

        // Calcul de la valeur totale du portefeuille
        //   for (PortefeuilleProduit produit : produits) {
    //     float prixActuel = yahooFinanceService.getPrixActuel(produit.getSymboleProduit());
    //      valeurTotalePortefeuille += produit.getQuantite() * prixActuel;
    //   }

    //   if (valeurTotalePortefeuille == 0) {
    //       throw new RuntimeException("La valeur totale du portefeuille est nulle.");
    //    }

        // Calcul des poids pour chaque produit
        //     for (PortefeuilleProduit produit : produits) {
        //       float prixActuel = yahooFinanceService.getPrixActuel(produit.getSymboleProduit());
        //    float valeurProduit = produit.getQuantite() * prixActuel;
    //     float poids = (valeurProduit / valeurTotalePortefeuille) * 100;
    //     poidsProduits.put(produit.getSymboleProduit(), poids);
    //    }

    //     return poidsProduits;
    //  }

    // Méthode utilitaire pour formater un pourcentage
    //   private String formatPercentage(float value) {
    //  return DECIMAL_FORMAT.format(value) + " %";
    //  }
}

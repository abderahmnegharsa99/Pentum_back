package tn.esprit.tradingback.Controlleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tradingback.Entities.Portfeuille;
import tn.esprit.tradingback.Services.PortfeuilleService;

import java.util.Map;

@RestController
@RequestMapping("/api/portefeuilles")
@CrossOrigin(origins = "http://localhost:4200")
public class PortefeuilleController {

//    @Autowired
//    private PortfeuilleService portefeuilleService;
//
//    //     Récupérer un portefeuille par ID
//    @GetMapping("/{id}")
//    public Portfeuille getPortefeuilleById(@PathVariable Long id) {
//        return portefeuilleService.getPortefeuilleById(id);
//    }
//
//    //     Endpoint pour récupérer les rendements par produit (formaté en pourcentage)
//    @GetMapping("/{id}/rendements")
//    public Map<String, String> getRendementsParPortefeuilleId(@PathVariable Long id) {
//        return portefeuilleService.calculerRendementsParPortefeuilleId(id);
//    }
//
//    //     Endpoint pour récupérer les valeurs totales par produit
//    @GetMapping("/{id}/valeurs-totales")
//    public Map<String, Float> getValeursTotales(@PathVariable Long id) {
//        return portefeuilleService.calculerValeursTotales(id);
//    }
//
//    //     Endpoint pour récupérer le profit ou perte par produit
//    @GetMapping("/{id}/profit-ou-perte")
//    public Map<String, Float> getProfitOuPerte(@PathVariable Long id) {
//        return portefeuilleService.calculerProfitOuPerte(id);
//    }
//
//    //     Endpoint pour récupérer le rendement global (formaté en pourcentage)
//    @GetMapping("/{id}/rendement-global")
//    public float getRendementGlobal(@PathVariable Long id) {
//        return portefeuilleService.calculerRendementGlobal(id); // Retourne un float directement
//    }
//
//
//    //     Endpoint pour sauvegarder les rendements dans l'historique
//    @PostMapping("/{id}/sauvegarder-rendements")
//    public void sauvegarderRendements(@PathVariable Long id) {
//        portefeuilleService.sauvegarderRendements(id);
//    }
//
//    //     Endpoint pour calculer le ratio gain/perte
//    @GetMapping("/{id}/ratio-gain-perte")
//    public float getRatioGainPerte(@PathVariable Long id) {
//        return portefeuilleService.calculerRatioGainPerte(id);
//    }
//
//    //     Endpoint pour calculer le poids des produits
//    @GetMapping("/{id}/poids-produits")
//    public Map<String, Float> getPoidsProduits(@PathVariable Long id) {
//        return portefeuilleService.calculerPoidsProduits(id);
//    }
}

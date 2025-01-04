package tn.esprit.tradingback.Services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tradingback.Entities.Enums.TypeOrdre;
import tn.esprit.tradingback.Entities.Ordre;
import tn.esprit.tradingback.Entities.PortefeuilleProduit;
import tn.esprit.tradingback.Entities.Portfeuille;
import tn.esprit.tradingback.Entities.User;
import tn.esprit.tradingback.Repositories.OrdreRepository;
import tn.esprit.tradingback.Repositories.PortefeuilleProduitRepository;
import tn.esprit.tradingback.Repositories.PortefeuilleRepository;
import tn.esprit.tradingback.Repositories.UserRepository;
import tn.esprit.tradingback.Services.Interfaces.IOrdreService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdreService implements IOrdreService {

    @Autowired
    private OrdreRepository ordreRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PortefeuilleRepository portefeuilleRepository;
    @Autowired
    private PortefeuilleProduitRepository portefeuilleProduitRepository;

    public User getCurrentAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        } else {
            throw new RuntimeException("User not authenticated");
        }
    }

    public List<Ordre> getOrdersForCurrentUser() {
        User currentUser = getCurrentAuthenticatedUser();
        Long userId = currentUser.getIdU();
        return ordreRepository.findByPortfeuille_UserIdU(userId);
    }

    public List<Ordre> getAllOrders() {
        return ordreRepository.findAll();
    }

    public Ordre passerOrdre(Ordre ordre) throws Exception {
        Portfeuille portefeuille = ordre.getPortfeuille();

        // Initialisation de l'état de l'ordre
        ordre.setEtat("EN_ATTENTE");

        if (ordre.getTypeOrdre() == TypeOrdre.ACHAT) {
            float montantTotal = ordre.getPrix() * ordre.getQuantite();
            if (portefeuille.getSolde() < montantTotal) {
                throw new Exception("Solde insuffisant pour passer l'ordre d'achat.");
            }
        }

        // Sauvegarde de l'ordre avec la date actuelle
        ordre.setDate(new Date());
        return ordreRepository.save(ordre);
    }

    public List<Ordre> getOrdresEnAttente() {
        return ordreRepository.findByEtat("EN_ATTENTE");
    }

    public Ordre confirmerOrdre(Long id) throws Exception {
        Optional<Ordre> optionalOrdre = ordreRepository.findById(id);
        if (optionalOrdre.isPresent()) {
            Ordre ordre = optionalOrdre.get();

            if (!"EN_ATTENTE".equals(ordre.getEtat())) {
                throw new Exception("L'ordre n'est pas en attente.");
            }

            // Passer l'état à ACCEPTÉ
            ordre.setEtat("ACCEPTE");

            // Si c'est un ordre d'achat, gérer le débit et l'ajout au portefeuille
            if (ordre.getTypeOrdre() == TypeOrdre.ACHAT) {
                float montantTotal = ordre.getPrix() * ordre.getQuantite();
                Portfeuille portefeuille = ordre.getPortfeuille();
                System.out.println(portefeuille.getOrdres());
                portefeuille.setSolde(portefeuille.getSolde() - montantTotal);
                portefeuilleRepository.save(portefeuille);

                // Ajouter ou mettre à jour le produit dans le portefeuille
                handleOrderAccepted(ordre);
            }

            return ordreRepository.save(ordre);
        } else {
            throw new Exception("Ordre non trouvé.");
        }
    }

    private void handleOrderAccepted(Ordre ordre) {
        Portfeuille portefeuille = ordre.getPortfeuille();
        if (portefeuille == null) {
            throw new IllegalStateException("Le portefeuille associé à cet ordre est introuvable.");
        }

        // Utilisez l'ID du portefeuille
        Optional<PortefeuilleProduit> produitExistant = portefeuilleProduitRepository.findBySymboleProduitAndPortefeuille(
                ordre.getSymboleProduit(), portefeuille.getIdPortfeuille()
        );

        if (produitExistant.isPresent()) {
            // Mettre à jour la quantité du produit existant
            PortefeuilleProduit produit = produitExistant.get();
            produit.setQuantite(produit.getQuantite() + ordre.getQuantite());
            produit.setPrixAchat(ordre.getPrix());
            portefeuilleProduitRepository.save(produit);
        } else {
            // Ajouter un nouveau produit au portefeuille
            PortefeuilleProduit nouveauProduit = new PortefeuilleProduit();
            nouveauProduit.setSymboleProduit(ordre.getSymboleProduit());
            nouveauProduit.setTypeProduit(ordre.getTypeProduit());
            nouveauProduit.setQuantite(ordre.getQuantite());
            nouveauProduit.setPrixAchat(ordre.getPrix());
            nouveauProduit.setPortefeuille(portefeuille);
            portefeuilleProduitRepository.save(nouveauProduit);
        }
    }




    public Ordre refuserOrdre(Long idOrdre) throws Exception {
        Optional<Ordre> optionalOrdre = ordreRepository.findById(idOrdre);
        if (optionalOrdre.isPresent()) {
            Ordre ordre = optionalOrdre.get();
            if (!"EN_ATTENTE".equals(ordre.getEtat())) {
                throw new Exception("L'ordre n'est pas en attente.");
            }

            ordre.setEtat("REFUSE");
            return ordreRepository.save(ordre);
        } else {
            throw new Exception("Ordre non trouvé.");
        }
    }
}

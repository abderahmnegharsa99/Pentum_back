package tn.esprit.tradingback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tradingback.Entities.PortefeuilleProduit;
import tn.esprit.tradingback.Entities.Portfeuille;

import java.util.List;
import java.util.Optional;

public interface PortefeuilleProduitRepository extends JpaRepository<PortefeuilleProduit, Long> {
   // Optional<PortefeuilleProduit> findBySymboleProduitAndPortefeuille(String symboleProduit, Portfeuille portefeuille);
   @Query("SELECT p FROM PortefeuilleProduit p WHERE p.symboleProduit = :symboleProduit AND p.portefeuille.idPortfeuille = :portefeuilleId")
   Optional<PortefeuilleProduit> findBySymboleProduitAndPortefeuille(
           @Param("symboleProduit") String symboleProduit,
           @Param("portefeuilleId") Long portefeuilleId
   );
   @Query("SELECT p FROM PortefeuilleProduit p WHERE p.portefeuille.idPortfeuille = :portefeuilleId")
   List<PortefeuilleProduit> findByPortefeuilleId(@Param("portefeuilleId") Long portefeuilleId);

}

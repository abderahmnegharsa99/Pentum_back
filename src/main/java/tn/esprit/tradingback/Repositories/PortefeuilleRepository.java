package tn.esprit.tradingback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tradingback.Entities.Marche;

import tn.esprit.tradingback.Entities.Portfeuille;

import java.util.Optional;

@Repository

public interface PortefeuilleRepository extends JpaRepository<Portfeuille, Long> {
    Optional<Portfeuille> findByUser_IdU(Long idU); // 'IdU' doit correspondre à la propriété de User


}

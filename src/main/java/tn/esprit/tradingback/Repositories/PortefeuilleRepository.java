package tn.esprit.tradingback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tradingback.Entities.Portfeuille;

@Repository

public interface PortefeuilleRepository extends JpaRepository<Portfeuille, Long> {
}

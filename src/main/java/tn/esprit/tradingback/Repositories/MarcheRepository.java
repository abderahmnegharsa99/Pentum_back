package tn.esprit.tradingback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tradingback.Entities.Marche;
import tn.esprit.tradingback.dto.ProduitFinancierDto;

import java.util.List;

@Repository

public interface MarcheRepository extends JpaRepository<Marche, Long> {

}

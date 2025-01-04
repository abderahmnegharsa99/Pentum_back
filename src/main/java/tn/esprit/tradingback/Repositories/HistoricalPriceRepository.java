package tn.esprit.tradingback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tradingback.Entities.HistoricalPrice;

import java.util.List;

public interface HistoricalPriceRepository extends JpaRepository<HistoricalPrice, String> {
    List<HistoricalPrice> findBySymbolOrderByDateAsc(String symbol);
}

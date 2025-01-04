package tn.esprit.tradingback.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class HistoricalPrice {
    @Id
    private String id; // Concaténation de symbol et date pour unique ID
    private String symbol;
    private double open;
    private double close;
    private double high;
    private double low;
    private double volume;
    private LocalDate date;
}

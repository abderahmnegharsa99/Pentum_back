package tn.esprit.tradingback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class HistoricalPriceDto {
    private double open;
    private double close;
    private double high;
    private double low;
    private double volume;

    @JsonProperty("date")
    private OffsetDateTime date;
}

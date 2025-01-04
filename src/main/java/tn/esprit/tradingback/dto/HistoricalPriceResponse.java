package tn.esprit.tradingback.dto;

import java.util.List;

public class HistoricalPriceResponse {
    private List<HistoricalPriceDto> data;

    public List<HistoricalPriceDto> getData() {
        return data;
    }

    public void setData(List<HistoricalPriceDto> data) {
        this.data = data;
    }
}

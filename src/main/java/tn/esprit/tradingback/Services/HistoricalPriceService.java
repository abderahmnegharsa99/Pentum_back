package tn.esprit.tradingback.Services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.esprit.tradingback.Entities.HistoricalPrice;
import tn.esprit.tradingback.Repositories.HistoricalPriceRepository;
import tn.esprit.tradingback.dto.HistoricalPriceResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricalPriceService {
 //   @Value("c4c2658ba99ffcdf5448e4b2e05de833")
    //     private String apiKey;

    //     private static final String MARKETSTACK_URL = "http://api.marketstack.com/v1/eod?access_key=%s&symbols=%s";

    //   private final HistoricalPriceRepository repository;
    //    private final RestTemplate restTemplate;

    //    public HistoricalPriceService(HistoricalPriceRepository repository, RestTemplate restTemplate) {
    //       this.repository = repository;
    //        this.restTemplate = restTemplate;
    //   }

    //    @Cacheable(value = "historicalPrices", key = "#symbol")
    //    public List<HistoricalPrice> getHistoricalPrices(String symbol) {
    //        String url = String.format(MARKETSTACK_URL, apiKey, symbol);
    //    HistoricalPriceResponse response = restTemplate.getForObject(url, HistoricalPriceResponse.class);

    //    if (response != null && response.getData() != null) {
    //        List<HistoricalPrice> prices = response.getData().stream().map(dto -> {
    //          HistoricalPrice price = new HistoricalPrice();
    //           price.setId(symbol + "-" + dto.getDate());
    //            price.setSymbol(symbol);
    //             price.setOpen(dto.getOpen());
    //           price.setClose(dto.getClose());
    //           price.setHigh(dto.getHigh());
    //           price.setLow(dto.getLow());
    //         price.setVolume(dto.getVolume());
    //          price.setDate(dto.getDate().toLocalDate());
    //           return price;
    //      }).collect(Collectors.toList());

    //        repository.saveAll(prices);
    //      return prices;
    //   }

    //     return repository.findBySymbolOrderByDateAsc(symbol);
    //  }
}


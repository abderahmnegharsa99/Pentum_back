package tn.esprit.tradingback.Controlleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tradingback.Entities.HistoricalPrice;
import tn.esprit.tradingback.Services.HistoricalPriceService;

import java.util.List;

@RestController
@RequestMapping("/api/historical")
@CrossOrigin(origins = "http://localhost:4200")
public class HistoricalPriceController {
 //   @Autowired
    //   private HistoricalPriceService historicalPriceService;

    //    @GetMapping("/{symbol}")
    //   public List<HistoricalPrice> getHistoricalPrices(@PathVariable String symbol) {
    //       return historicalPriceService.getHistoricalPrices(symbol);
    //   }
}

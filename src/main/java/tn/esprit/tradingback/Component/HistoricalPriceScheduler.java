package tn.esprit.tradingback.Component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.tradingback.Services.HistoricalPriceService;

@Component
public class HistoricalPriceScheduler {
    //  private final HistoricalPriceService historicalPriceService;

    // public HistoricalPriceScheduler(HistoricalPriceService historicalPriceService) {
    //      this.historicalPriceService = historicalPriceService;
    //   }

//    @Scheduled(cron = "0 0 23 * * ?") // yexécuti kolyum  à 23h00
   // @Scheduled(cron = "0 * * * * ?")//yexecuti chaque minutea

    //    public void refreshHistoricalData() { System.out.println("refreshhy el data b new data ml api ...");
        // Ajoutez des symboles à actualiser selon votre choix
    //       String[] symbols = {"AAPL", "MSFT", "GOOGL","AMR"};
    //      for (String symbol : symbols) {
    //           historicalPriceService.getHistoricalPrices(symbol);
    //       }
//    }
}

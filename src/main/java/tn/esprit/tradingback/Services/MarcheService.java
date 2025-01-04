package tn.esprit.tradingback.Services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.esprit.tradingback.Services.Interfaces.IMarcheService;
import tn.esprit.tradingback.dto.ProduitFinancierDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcheService implements IMarcheService {
    //    private static final String API_KEY = "b5e83d7135msh4b08d67ee977af4p128d1bjsn0db99bbddccb"; // clé secret  taa api RapidAPI
    //   private static final String API_URL = "https://twelve-data1.p.rapidapi.com/time_series?interval=1day&outputsize=1&format=json&symbol=";

    //   @Autowired
    //   public MarcheService(CacheManager cacheManager) {
    //   }

    // Method to call API for multiple symbols
    //    public List<ProduitFinancierDto> appelerAPITwelveData(List<String> symbols) {
    //      List<ProduitFinancierDto> actions = new ArrayList<>();
    //       try {
            // Construct the URL with multiple symbols
    //           String symbolParam = symbols.stream().collect(Collectors.joining(","));
    //           String url = API_URL + symbolParam;

            // Set headers for RapidAPI authentication
    //            HttpHeaders headers = new HttpHeaders();
    //          headers.set("x-rapidapi-key", API_KEY);
    //          headers.set("x-rapidapi-host", "twelve-data1.p.rapidapi.com");

    //           HttpEntity<String> entity = new HttpEntity<>(headers);

    //         RestTemplate restTemplate = new RestTemplate();
    //         ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    //         System.out.println("Entire Response JSON (Multiple Symbols): " + response.getBody());

            // Parse the response JSON
    //           JSONObject jsonResponse = new JSONObject(response.getBody());

            // Iterate over each symbol in the response
    //            for (String symbol : symbols) {
            //             if (jsonResponse.has(symbol)) {
    //          JSONObject symbolData = jsonResponse.getJSONObject(symbol);

                    // Check for meta and values fields
            //               if (symbolData.has("meta") && symbolData.has("values")) {
                    //              JSONObject meta = symbolData.getJSONObject("meta");
    //               JSONArray valuesArray = symbolData.getJSONArray("values");

    //                  if (valuesArray.length() > 0) {
    //                     JSONObject latestValue = valuesArray.getJSONObject(0);

                            // Extract data
                            //                       String type = meta.getString("type");
                            //                        String exchange = meta.getString("exchange");
                            //                       String currency = meta.getString("currency");
                            //                        float prixOuverture = Float.parseFloat(latestValue.getString("open"));
                            //                 float prixHaut = Float.parseFloat(latestValue.getString("high"));
                            //                      float prixBas = Float.parseFloat(latestValue.getString("low"));
                            //                     float prixActuel = Float.parseFloat(latestValue.getString("close"));
                            //                     long volume = Long.parseLong(latestValue.getString("volume"));
    //                      String derniereMiseAJour = latestValue.getString("datetime");

    //                    actions.add(new ProduitFinancierDto(
    //                            symbol,
    //                             type,
    //                           prixActuel,
    //                           prixOuverture,
    //                              prixHaut,
    //                              prixBas,
    //                               volume,
    //                               derniereMiseAJour,
    //                             exchange,
            //                              currency
    //                     ));
    //                   }
    //               } else {
    //                     System.out.println("Meta or values not found for symbol: " + symbol);
    //                   }
    //             } else {
        //                  System.out.println("Symbol not found in the response: " + symbol);
    //            }
    //         }
    //      } catch (Exception e) {
    //          e.printStackTrace();
    //       }
    //      System.out.println("Actions list before return (Multiple): " + actions);
    //      return actions;
    //   }

    // Method to call API for a single symbol
    //    public ProduitFinancierDto appelerAPITwelveDataSingle(String symbol) {
    //       try {
            // Construct the URL with the single symbol
    //          String url = API_URL + symbol;

            // Set headers for RapidAPI authentication
    //         HttpHeaders headers = new HttpHeaders();
    //        headers.set("x-rapidapi-key", API_KEY);
    //       headers.set("x-rapidapi-host", "twelve-data1.p.rapidapi.com");

    //      HttpEntity<String> entity = new HttpEntity<>(headers);

    //       RestTemplate restTemplate = new RestTemplate();
    //          ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    //       System.out.println("Entire Response JSON (Single Symbol): " + response.getBody());

            // Parse the response JSON
    //        JSONObject jsonResponse = new JSONObject(response.getBody());

    //         if (jsonResponse.has("meta") && jsonResponse.has("values")) {
    //             JSONObject meta = jsonResponse.getJSONObject("meta");
    //          JSONArray valuesArray = jsonResponse.getJSONArray("values");

    //          if (valuesArray.length() > 0) {
    //              JSONObject latestValue = valuesArray.getJSONObject(0);
    //
                    // Extract data
    //               String type = meta.getString("type");
    //             String exchange = meta.getString("exchange");
    //             String currency = meta.getString("currency");
    //              float prixOuverture = Float.parseFloat(latestValue.getString("open"));
    //       float prixHaut = Float.parseFloat(latestValue.getString("high"));
    //       float prixBas = Float.parseFloat(latestValue.getString("low"));
    //       float prixActuel = Float.parseFloat(latestValue.getString("close"));
    //         long volume = Long.parseLong(latestValue.getString("volume"));
    //               String derniereMiseAJour = latestValue.getString("datetime");

    //               return new ProduitFinancierDto(
    //                       symbol,
    //                        type,
    //                        prixActuel,
    //                        prixOuverture,
    //                        prixHaut,
    //                       prixBas,
    //                        volume,
    //                        derniereMiseAJour,
    //                        exchange,
    //                       currency
    //                );
    //             }
    //         } else {
    //             System.out.println("Required fields 'meta' or 'values' not found in response (Single): " + symbol);
    //         }
//     } catch (Exception e) {
    //           e.printStackTrace();
    //       }
    //        return null;
    //    }
}

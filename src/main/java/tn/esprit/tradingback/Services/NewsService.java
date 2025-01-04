package tn.esprit.tradingback.Services;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import tn.esprit.tradingback.dto.NewsResponse;

@CrossOrigin(origins = "*")
@Service
public class NewsService {

    //    private final RestTemplate restTemplate;

    //   @Value("${newsapi.apiKey}")
    //   private String apiKey;

    //   public NewsService(RestTemplate restTemplate) {
    //     this.restTemplate = restTemplate;
    //    }

    //    public NewsResponse getArticles(String symbol) {
    //       System.out.println("Method getArticles called with symbol: " + symbol);
    //       String url = "https://newsapi.org/v2/everything?q=" + symbol + "&apiKey=" + apiKey;
    //      System.out.println("URL construite : " + url);


    //       try {
    //        NewsResponse response = this.restTemplate.getForObject(url, NewsResponse.class);
    //       System.out.println("Réponse reçue : " + response);
    //         return response;
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //         return null;
    //      }
    //   }

}

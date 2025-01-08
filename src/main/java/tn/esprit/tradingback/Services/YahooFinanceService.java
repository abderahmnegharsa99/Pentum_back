package tn.esprit.tradingback.Services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class YahooFinanceService {

    private final String API_URL = "https://yahoo-finance166.p.rapidapi.com/api/stock/get-financial-data";
    private final String API_HOST = "yahoo-finance166.p.rapidapi.com";

    private final String API_KEY = "b5e83d7135msh4b08d67ee977af4p128d1bjsn0db99bbddccb";


    public float getPrixActuel(String symbole) {
        RestTemplate restTemplate = new RestTemplate();

//        Configurer les en - têtes
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", API_HOST);
        headers.set("X-RapidAPI-Key", API_KEY);

//        Construire l 'URL
        String url = API_URL + "?region=US&symbol=" + symbole;

//        Envoyer la requête
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

//        Traiter la réponse JSON
        JSONObject jsonResponse = new JSONObject(response.getBody());
        float prixActuel = jsonResponse
                .getJSONObject("quoteSummary")
                .getJSONArray("result")
                .getJSONObject(0)
                .getJSONObject("financialData")
                .getJSONObject("currentPrice")
                .getFloat("raw");

        return prixActuel;
    }
}

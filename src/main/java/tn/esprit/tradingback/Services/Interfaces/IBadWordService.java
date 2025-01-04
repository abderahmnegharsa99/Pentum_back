package tn.esprit.tradingback.Services.Interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IBadWordService {
    public ResponseEntity<String> filterBadWords(String text);
}

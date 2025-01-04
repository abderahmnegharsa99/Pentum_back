package tn.esprit.tradingback.Controlleurs;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tradingback.Services.NewsService;
import tn.esprit.tradingback.dto.NewsResponse;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*")
public class NewsController {

    //  private final NewsService newsService;

    //  @Autowired
    //  public NewsController(NewsService newsService) {
    //      this.newsService = newsService;
    //      System.out.println("Controller initialized");
    //   }

    //  @GetMapping
    //  public ResponseEntity<NewsResponse> getNews(@RequestParam String symbol) {
    //      NewsResponse response = this.newsService.getArticles(symbol);
    //      return ResponseEntity.ok().body(response);
    //   }



}



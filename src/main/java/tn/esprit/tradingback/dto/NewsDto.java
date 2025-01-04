package tn.esprit.tradingback.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsDto {

    @JsonIgnore
    private String title;

    @JsonIgnore
    private String description;

    @JsonIgnore
    private String url;

    @JsonIgnore
    private String urlToImage;

    @JsonIgnore
    private String publishedAt;

    // Getters and Setters are provided by Lombok
}

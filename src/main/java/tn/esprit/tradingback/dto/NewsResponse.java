package tn.esprit.tradingback.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("totalResults")
    private int totalResults;

    @JsonProperty("articles")
    private List<Article> articles;

    // Inner class for Article
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Article {

        @JsonProperty("source")
        private Source source;

        @JsonProperty("author")
        private String author;

        @JsonProperty("title")
        private String title;

        @JsonProperty("description")
        private String description;

        @JsonProperty("url")
        private String url;

        @JsonProperty("urlToImage")
        private String urlToImage;

        @JsonProperty("publishedAt")
        private String publishedAt;

        @JsonProperty("content")
        private String content;

        // Getters and Setters are provided by Lombok
    }

    // Inner class for Source
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Source {

        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        // Getters and Setters are provided by Lombok
    }
}

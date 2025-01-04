package tn.esprit.tradingback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TradingBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingBackApplication.class, args);
	}

}

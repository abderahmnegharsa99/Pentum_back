package tn.esprit.tradingback.Controlleurs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tn.esprit.tradingback.Services.Interfaces.IMarcheService;
import tn.esprit.tradingback.Services.MarcheService;
import tn.esprit.tradingback.dto.ProduitFinancierDto;

import java.util.List;
@Getter
@Setter
@EnableWebMvc
@RestController
@RequestMapping("/marche")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcheController {
    //  @Autowired
    //  private IMarcheService marcheService;



    //  @GetMapping("/actions/{symbol}")
    //   public ProduitFinancierDto getAction(@PathVariable String symbol) {
    //      return marcheService.appelerAPITwelveDataSingle(symbol);
//    }

    //   @GetMapping("/actions")
    //   public List<ProduitFinancierDto> getActions(@RequestParam(name = "symbols") List<String> symbols) {
    //      return marcheService.appelerAPITwelveData(symbols);

    //  }

}

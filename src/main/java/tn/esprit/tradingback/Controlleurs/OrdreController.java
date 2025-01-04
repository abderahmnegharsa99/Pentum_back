package tn.esprit.tradingback.Controlleurs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tradingback.Entities.Enums.TypeOrdre;
import tn.esprit.tradingback.Entities.Ordre;
import tn.esprit.tradingback.Entities.Portfeuille;
import tn.esprit.tradingback.Repositories.OrdreRepository;
import tn.esprit.tradingback.Repositories.PortefeuilleRepository;
import tn.esprit.tradingback.Services.OrdreService;
import tn.esprit.tradingback.dto.OrdreDTO;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/ordres")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdreController {

    @Autowired
    private OrdreService ordreService;
    @Autowired
    private PortefeuilleRepository portefeuilleRepository;

    @Autowired
    private OrdreRepository ordreRepository;

    @PostMapping("/passer")
  /*  public ResponseEntity<?> passerOrdre(@RequestBody Ordre ordre) {
        try {
            Ordre nouvelOrdre = ordreService.passerOrdre(ordre);
            return new ResponseEntity<>(nouvelOrdre, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }*/

    public Ordre passerOrdre(@RequestBody OrdreDTO ordreDTO) throws Exception {
        System.out.println("Objet reçu : " + ordreDTO);

        if (ordreDTO.getIdPortfeuille() == null) {
            throw new Exception("Le portefeuille associé est nul ou mal défini.");
        }

        Portfeuille portefeuille = portefeuilleRepository.findById(ordreDTO.getIdPortfeuille())
                .orElseThrow(() -> new Exception("Portefeuille introuvable avec l'ID : " + ordreDTO.getIdPortfeuille()));

        Ordre ordre = new Ordre();
        ordre.setSymboleProduit(ordreDTO.getSymboleProduit());
        ordre.setTypeProduit(ordreDTO.getTypeProduit());
        ordre.setPrix(ordreDTO.getPrix());
        ordre.setQuantite(ordreDTO.getQuantite());
        ordre.setTypeOrdre(TypeOrdre.ACHAT);
        ordre.setPortfeuille(portefeuille);
        ordre.setEtat("EN_ATTENTE");
        ordre.setDate(new Date());

        return ordreRepository.save(ordre);
    }


    @GetMapping("/en-attente")
    public ResponseEntity<List<Ordre>> getOrdresEnAttente() {
        List<Ordre> ordresEnAttente = ordreService.getOrdresEnAttente();
        return new ResponseEntity<>(ordresEnAttente, HttpStatus.OK);
    }

    @PostMapping("/accepter/{id}")
    public ResponseEntity<?> accepterOrdre(@PathVariable Long id) {
        try {
            Ordre ordreAccepte = ordreService.confirmerOrdre(id);
            return new ResponseEntity<>(ordreAccepte, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/rejeter/{id}")
    public ResponseEntity<?> refuserOrdre(@PathVariable Long id) {
        try {
            Ordre ordreRefuse = ordreService.refuserOrdre(id);
            return new ResponseEntity<>(ordreRefuse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/user-orders")
    public ResponseEntity<List<Ordre>> getOrdersForCurrentUser() {
        try {
            List<Ordre> userOrders = ordreService.getOrdersForCurrentUser();
            return new ResponseEntity<>(userOrders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.UNAUTHORIZED);
        }
    } @GetMapping("/all")
    public ResponseEntity<List<Ordre>> getAllOrders() {
        try {
            List<Ordre> orders = ordreService.getAllOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

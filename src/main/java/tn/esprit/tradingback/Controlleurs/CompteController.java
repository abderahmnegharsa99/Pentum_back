package tn.esprit.tradingback.Controlleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.tradingback.Repositories.CompteRepository;
import tn.esprit.tradingback.Repositories.UserRepository;
import tn.esprit.tradingback.Services.CompteService;

import java.util.List;
import java.util.stream.Collectors;

public class CompteController {

    //    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private CompteRepository compteRepository;
//
//
//    @Autowired
//    private CompteService compteService;
//
//    @GetMapping("/all")
//    public ResponseEntity<List<CompteBancaireResponseDTO>> getAllCompteBancaire() {
//        List<CompteBancaireResponseDTO> response = compteBancaireRepository.findAll().stream()
//                .map(compteBancaire -> new CompteBancaireResponseDTO(
//                        compteBancaire.getIdCmpt(),
//                        compteBancaire.getNumCompte(),
//                        compteBancaire.getNomBanque(),
//                        compteBancaire.getSoldeCompte(),
//                        compteBancaire.getUser() != null ? compteBancaire.getUser().getNom() + " " + compteBancaire.getUser().getPrenom() : "No user"
//                ))
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CompteBancaireResponseDTO> getCompteBancaireById(@PathVariable Long id) {
//        return compteBancaireRepository.findById(id)
//                .map(compteBancaire -> new CompteBancaireResponseDTO(
//                        compteBancaire.getIdCmpt(),
//                        compteBancaire.getNumCompte(),
//                        compteBancaire.getNomBanque(),
//                        compteBancaire.getSoldeCompte(),
//                        compteBancaire.getUser() != null ? compteBancaire.getUser().getNom() + " " + compteBancaire.getUser().getPrenom() : "No user"
//                ))
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

}

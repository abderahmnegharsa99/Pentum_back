package tn.esprit.tradingback.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tradingback.Repositories.CompteRepository;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

}

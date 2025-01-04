package tn.esprit.tradingback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.esprit.tradingback.Entities.Portfeuille;
import tn.esprit.tradingback.Entities.User;
import tn.esprit.tradingback.Repositories.PortefeuilleRepository;
import tn.esprit.tradingback.Repositories.UserRepository;
import tn.esprit.tradingback.Services.Interfaces.IUserService;

import java.util.Optional;

@Service
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PortefeuilleRepository portefeuilleRepository;

    // Assign Portefeuille to User
    public User assignPortefeuilleToUser(Long idU, Portfeuille portefeuille) {
        User user = userRepository.findById(idU)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // You can create a new Portefeuille or use the existing one
        Portfeuille newPortefeuille = portefeuilleRepository.save(portefeuille);

        // Assign the portefeuille to the user
        //user.setPortefeuille(newPortefeuille);

        // Save the user with the updated portefeuille
        return userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByMail(email);
    }


}

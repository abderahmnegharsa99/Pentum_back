package tn.esprit.tradingback.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.tradingback.Entities.Enums.ROLE;
import tn.esprit.tradingback.Entities.PasswordResetToken;
import tn.esprit.tradingback.Entities.Portfeuille;
import tn.esprit.tradingback.Entities.User;
import tn.esprit.tradingback.Repositories.PasswordResetTokenRepository;
import tn.esprit.tradingback.Repositories.PortefeuilleRepository;
import tn.esprit.tradingback.Repositories.UserRepository;
import tn.esprit.tradingback.Services.JwtService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository iUserRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final PasswordResetTokenRepository tokenRepository;
  private final JavaMailSender mailSender;
  private final PortefeuilleRepository portefeuilleRepository; // Inject PortefeuilleRepository

  public AuthenticationResponse register(RegistreRequest request) {
    // Create and save the new User without the portefeuille
    User user = User.builder()
            .nom(request.getNom())
            .prenom(request.getPrenom())
            .numCin(request.getNumCin())
            .dateDeNaissance(request.getDateDeNaissance())
            .mail(request.getMail())
            .paysDeNaissance(request.getPaysDeNaissance())
            .nationalite(request.getNationalite())
            .adress(request.getAdress())
            .codePostal(request.getCodePostal())
            .contact(request.getContact())
            .motDePasse(passwordEncoder.encode(request.getMotDePasse()))
            .role(ROLE.JOUEUR)
            .build();

    user = iUserRepository.save(user);
    System.out.println("After initial saving User: " + user);

// Create the Portfeuille, associating it with the User
    Portfeuille portefeuille = new Portfeuille();
    portefeuille.setDateOuverture(new Date());
    portefeuille.setSolde(50000f);
    portefeuille.setUser(user);

// Save the Portfeuille
    portefeuille = portefeuilleRepository.save(portefeuille);
    System.out.println("After saving Portfeuille: " + portefeuille);

// Update the User entity with the saved Portfeuille and save again
    user.setPortfeuille(portefeuille);
    user = iUserRepository.save(user); // Explicitly save the user again

    System.out.println("After updating User with Portfeuille: " + user);

// Generate and return the JWT token
    var jwtToken = jwtService.generateToken(user, user.getUsername());
    return AuthenticationResponse.builder()
            .accessToken(jwtToken)
            .build();

  }



  public AuthenticationResponse login(LoginRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getMail(),
                    request.getMotDePasse()
            )
    );
    var user = iUserRepository.findByMail(request.getMail())
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + request.getMail()));
    Map<String, Object> claims = new HashMap<>();
    String jwtToken = jwtService.generateToken(user, user.getUsername());

    return AuthenticationResponse.builder()
            .accessToken(jwtToken)
            .build();
  }

  public void createPasswordResetTokenForUser(User user, String token) {
    PasswordResetToken myToken = new PasswordResetToken(token, user);
    tokenRepository.save(myToken);
  }

  public void sendEmail(String recipientAddress, String subject, String message) {
    SimpleMailMessage email = new SimpleMailMessage();
    email.setTo(recipientAddress);
    email.setSubject(subject);
    email.setText(message);
    mailSender.send(email);
  }

  public Optional<User> findUserByMail(String mail) {
    return iUserRepository.findByMail(mail);
  }

  public void resetPassword(String token, String newPassword) {
    PasswordResetToken resetToken = tokenRepository.findByToken(token);
    if (resetToken == null || resetToken.isExpired()) {
      throw new IllegalArgumentException("Invalid or expired token");
    }

    User user = resetToken.getUser();
    user.setMotDePasse(passwordEncoder.encode(newPassword));
    iUserRepository.save(user);

    tokenRepository.delete(resetToken);
  }
}

package tn.esprit.tradingback.Controlleurs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tradingback.Entities.Portfeuille;
import tn.esprit.tradingback.Entities.User;
import tn.esprit.tradingback.Services.UserService;

import java.util.Optional;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{idU}/portefeuille")
    public ResponseEntity<User> assignPortefeuilleToUser(
            @PathVariable Long idU,
            @RequestBody Portfeuille portfeuille) {

        // Call the service to assign the portefeuille to the user
        User updatedUser = userService.assignPortefeuilleToUser(idU, portfeuille);

        // Return the updated user as the response
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/by-email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        // Call the service to fetch the user by email
        Optional<User> userOptional = userService.getUserByEmail(email);
        // If user is found, return the user; otherwise return 404 Not Found
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

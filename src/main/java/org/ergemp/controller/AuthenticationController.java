package org.ergemp.controller;

import org.ergemp.component.JwtTokenUtil;
import org.ergemp.model.Token;
import org.ergemp.model.User;
import org.ergemp.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/api/token")
    public ResponseEntity getToken(@RequestBody User user) {
        final UserDetails userDetails = customUserDetailsService.loadUserByUser(user);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new Token(token));
    }

    @PostMapping("/api/token/validate")
    public ResponseEntity validateToken(@RequestBody Token token) {
        if (jwtTokenUtil.validateToken(token.getToken())){
            return ResponseEntity.ok("VALIDATED");
        }
        else{
            return ResponseEntity.status(401).body("UNAUTHORIZED");
        }
    }

}

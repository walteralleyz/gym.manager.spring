package com.walteralleyz.gymmanager.controllers;

import com.walteralleyz.gymmanager.dto.request.StaffDTO;
import com.walteralleyz.gymmanager.repositories.StaffRepository;
import com.walteralleyz.gymmanager.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private StaffRepository staffRepository;

    @PostMapping("/signin")
    public ResponseEntity<Map<Object, Object>> signin(@RequestBody StaffDTO staffDTO) {
        try {
            String username = staffDTO.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, staffDTO.getPassword()));

            String token = jwtTokenProvider.createToken(
                username,
                staffRepository.findByUsername(username).getRole());

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);

            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}

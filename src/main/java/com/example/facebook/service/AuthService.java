package com.example.facebook.service;

import com.example.facebook.dto.request.AuthenticationRequest;
import com.example.facebook.exception.UserExistException;
import com.example.facebook.model.User;
import com.example.facebook.repository.UserRepository;
import com.example.facebook.security.jwt.JwtTokenProvider;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@Service
public class AuthService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserRepository users;

    public ResponseEntity signin(AuthenticationRequest data) {
        try {
            String username = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.createToken(username, this.users.findByName(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getRoles());

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    public ResponseEntity signup(AuthenticationRequest data) {
        Optional<User> user = this.users.findByName(data.getUsername());
        if (user.isPresent()) {
            throw new UserExistException("User existed");
        }
        User newUser = new User();
        newUser.setName(data.getUsername());
        newUser.setPassword(this.passwordEncoder.encode(data.getPassword()));

        User savedUser = this.users.save(newUser);

        String token = jwtTokenProvider.createToken(data.getUsername(), savedUser.getRoles());

        Map<Object, Object> model = new HashMap<>();
        model.put("token", token);
        return ok(model);
    }
}

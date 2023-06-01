package com.sivalabs.demo.web;

import com.sivalabs.demo.domain.User;
import com.sivalabs.demo.domain.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class UserRestController {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    UserRestController(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/api/users")
    @PreAuthorize("permitAll()")
    public List<User> getAll() {
        return repo.findAll();
    }

    @PostMapping("/api/users")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<User> create(@RequestBody @Validated User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = repo.save(user);
        return ResponseEntity.status(201).body(savedUser);
    }
}

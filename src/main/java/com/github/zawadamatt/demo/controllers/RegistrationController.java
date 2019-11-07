package com.github.zawadamatt.demo.controllers;

import com.github.zawadamatt.demo.model.domain.User;
import com.github.zawadamatt.demo.model.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class.getName());
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String prepareRegistrationPage() {
        return "/WEB-INF/views/registration-form.jsp";
    }

    @PostMapping
    public String processRegistrationPage(String username, String password, String firstName, String lastName) {
        User newUser = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .firstName(firstName)
                .lastName(lastName)
                .active(true)
                .build();
        userRepository.save(newUser);
        log.info("Zapisany użytkownik: " + newUser);
        return "redirect:/";
    }

}

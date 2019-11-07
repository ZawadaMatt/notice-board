package com.github.zawadamatt.demo.controllers;

import com.github.zawadamatt.demo.model.domain.Advert;
import com.github.zawadamatt.demo.model.domain.User;
import com.github.zawadamatt.demo.model.repositories.AdvertRepository;
import com.github.zawadamatt.demo.model.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDateTime;

@Slf4j

@Controller
public class AdvertController {

    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;

    @Autowired
    public AdvertController(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    @PostMapping("/add-advert")
    public String processAddAdvert(String title, String description, Principal principal) {
        log.info("Add advertise !");
        String username = principal.getName();
        User findUser = userRepository.findByUsername(username);
        Advert advert = Advert.builder()
                .title(title)
                .description(description)
                .user(findUser)
                .posted(LocalDateTime.now())
                .build();
        advertRepository.save(advert);
        log.info("Zapisano ogłoszenie !");
        return "redirect:/";
    }
}

package com.github.zawadamatt.demo.controllers;

import com.github.zawadamatt.demo.model.domain.Advert;
import com.github.zawadamatt.demo.model.repositories.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomePageController {

    private final AdvertRepository advertRepository;

    @Autowired
    public HomePageController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @GetMapping
    public String prepareHomePage(Model model) {
        List<Advert> advertList = advertRepository.findAllByOrderByPostedDesc();
        model.addAttribute("dateFormat", DateTimeFormatter.ofPattern("HH:mm dd:MM:yyyy"));
        model.addAttribute("advertList", advertList);
        return "/WEB-INF/views/home-page.jsp";
    }

    @PostMapping
    public String prepareHomePagePost(String title, String description) {
        return "/WEB-INF/views/home-page.jsp";
    }

}

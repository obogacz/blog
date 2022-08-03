package com.richcode.demo.rest;

import com.richcode.demo.model.SuperHero;
import com.richcode.demo.repository.SuperHeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/superheroes")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SuperHeroController {

    private final SuperHeroRepository repository;

    @GetMapping
    public List<SuperHero> list() {
        return repository.findAll();
    }

}

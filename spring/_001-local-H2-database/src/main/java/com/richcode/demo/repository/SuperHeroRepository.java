package com.richcode.demo.repository;

import com.richcode.demo.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Integer> {
}

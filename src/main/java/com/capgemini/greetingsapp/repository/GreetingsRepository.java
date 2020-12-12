package com.capgemini.greetingsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.greetingsapp.model.Greeting;

public interface GreetingsRepository extends JpaRepository<Greeting, Long> {

}

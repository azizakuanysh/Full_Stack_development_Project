package com.example.fullstack1.controller;

import com.example.fullstack1.domain.Car;
import com.example.fullstack1.domain.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class CarController {
    private final CarRepository repository;
    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cars")
    public Iterable <Car> getCars() {
        return repository.findAll();
    }

}

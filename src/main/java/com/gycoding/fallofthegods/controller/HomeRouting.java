package com.gycoding.fallofthegods.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gycoding.fallofthegods.model.entities.ServerStatus;

@RestController
public class HomeRouting {
    @GetMapping("/")
    public String home() {
        Resource resource = new ClassPathResource("static/reference-site/index.html");

        try {
            return new String(Files.readAllBytes(Paths.get(resource.getURI())));
        } catch (IOException e) {
            e.printStackTrace();
            return ServerStatus.NOT_FOUND.toString();
        }
    }
}

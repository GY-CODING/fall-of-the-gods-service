package com.gycoding.fallofthegods.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gycoding.fallofthegods.model.database.WorldService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/worlds")
public class WorldRouting {
    private final WorldService worldService;

    public WorldRouting(WorldService worldService) {
        this.worldService = worldService;
    }

    @GetMapping("/get")
    public String getWorld(@RequestParam int id) {
        return worldService.getWorld(id).toString();
    }

    @GetMapping("/get/place")
    public String getWorldPlace(@RequestParam int idWorld, @RequestParam int idPlace) {
        return worldService.getWorldPlace(idWorld, idPlace).toString();
    }

    @GetMapping("/list")
    public String listWorld() {
        return worldService.listWorlds().toString();
    }
}

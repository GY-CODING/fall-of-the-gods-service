package com.gycoding.fallofthegods.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gycoding.fallofthegods.model.database.WorldService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;

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
    public String getWorld(@RequestParam String id) {
        try {
            return worldService.getWorld(id).toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/get/place")
    public String getWorldPlace(@RequestParam int idWorld, @RequestParam int idPlace) {
        try {
            return worldService.getWorldPlace(idWorld, idPlace).toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/list")
    public String listWorld() {
        try {
            return worldService.listWorlds().toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }
}

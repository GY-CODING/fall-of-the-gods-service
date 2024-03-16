package com.gycoding.fallofthegods.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gycoding.fallofthegods.model.database.PlaceService;
import com.gycoding.fallofthegods.model.database.WorldService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/worlds")
public class WorldRouting {
    private final WorldService worldService;
    private final PlaceService placeService;

    public WorldRouting(WorldService worldService, PlaceService placeService) {
        this.worldService = worldService;
        this.placeService = placeService;
    }

    @GetMapping("/get")
    public String getWorld(@RequestParam String id) {
        try {
            return worldService.getWorld(id).toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }
    

    @GetMapping("/list")
    public String listWorlds() {
        try {
            return worldService.listWorlds().toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/places/get")
    public String getPlace(@RequestParam String id) {
        try {
            return placeService.getPlace(id).toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/places/listAll")
    public String listPlaces() {
        try {
            return placeService.listPlaces().toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/places/list")
    public String listWorldPlaces(@RequestParam String id) {
        try {
            return worldService.listWorldPlaces(id).toString();
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }
}

package com.gycoding.fallofthegods.controller;

import com.gycoding.fallofthegods.model.database.service.PlaceService;
import com.gycoding.fallofthegods.model.database.service.WorldService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worlds")
public class WorldController {
    private final WorldService worldService;
    private final PlaceService placeService;

    public WorldController(WorldService worldService, PlaceService placeService) {
        this.worldService   = worldService;
        this.placeService   = placeService;
    }

    @GetMapping("/get")
    public ResponseEntity<String> getWorld(@RequestParam String id) {
        try {
            return ResponseEntity.ok(worldService.getWorld(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.WORLD_NOT_FOUND.status).body(ServerStatus.WORLD_NOT_FOUND.toString());
        }
    }
    

    @GetMapping("/list")
    public ResponseEntity<String> listWorlds() {
        try {
            return ResponseEntity.ok(worldService.listWorlds().toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.WORLD_NOT_FOUND.status).body(ServerStatus.WORLD_NOT_FOUND.toString());
        }
    }

    @GetMapping("/places/get")
    public ResponseEntity<String> getPlace(@RequestParam String id) {
        try {
            return ResponseEntity.ok(placeService.getPlace(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.PLACE_NOT_FOUND.status).body(ServerStatus.PLACE_NOT_FOUND.toString());
        }
    }

    @GetMapping("/places/listAll")
    public ResponseEntity<String> listPlaces() {
        try {
            return ResponseEntity.ok(placeService.listPlaces().toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.PLACE_NOT_FOUND.status).body(ServerStatus.PLACE_NOT_FOUND.toString());
        }
    }

    @GetMapping("/places/list")
    public ResponseEntity<String> listWorldPlaces(@RequestParam String id) {
        try {
            return ResponseEntity.ok(worldService.listWorldPlaces(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.WORLD_NOT_FOUND.status).body(ServerStatus.WORLD_NOT_FOUND.toString());
        }
    }
}

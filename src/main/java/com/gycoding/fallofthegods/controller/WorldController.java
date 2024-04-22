package com.gycoding.fallofthegods.controller;

import com.gycoding.fallofthegods.model.database.service.PlaceService;
import com.gycoding.fallofthegods.model.database.service.WorldService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<?> getWorld(@RequestParam String id) {
        try {
            return ResponseEntity.ok(worldService.getWorld(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.WORLD_NOT_FOUND.status).body(ServerStatus.WORLD_NOT_FOUND.toString());
        }
    }
    

    @GetMapping("/list")
    public ResponseEntity<?> listWorlds(Pageable pageable) {
        try {
            return ResponseEntity.ok(worldService.listWorlds(pageable).getContent());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_WORLD_NOT_FOUND.status).body(ServerStatus.LIST_WORLD_NOT_FOUND.toString());
        }
    }

    @GetMapping("/places/get")
    public ResponseEntity<?> getPlace(@RequestParam String id) {
        try {
            return ResponseEntity.ok(placeService.getPlace(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.PLACE_NOT_FOUND.status).body(ServerStatus.PLACE_NOT_FOUND.toString());
        }
    }

    @GetMapping("/places/listAll")
    public ResponseEntity<?> listPlaces(Pageable pageable) {
        try {
            return ResponseEntity.ok(placeService.listPlaces(pageable).getContent());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_PLACE_NOT_FOUND.status).body(ServerStatus.LIST_PLACE_NOT_FOUND.toString());
        }
    }

    @GetMapping("/places/list")
    public ResponseEntity<?> listWorldPlaces(@RequestParam String id, Pageable pageable) {
        try {
            return ResponseEntity.ok(worldService.listWorldPlaces(id, pageable).getContent());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.LIST_WORLD_NOT_FOUND.status).body(ServerStatus.LIST_WORLD_NOT_FOUND.toString());
        }
    }
}

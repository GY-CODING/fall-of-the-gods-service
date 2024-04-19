package com.gycoding.fallofthegods.controller;

import com.gycoding.fallofthegods.model.database.service.PlaceService;
import com.gycoding.fallofthegods.model.database.service.TokenService;
import com.gycoding.fallofthegods.model.database.service.WorldService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/{token}/worlds")
public class WorldController {
    private final WorldService worldService;
    private final PlaceService placeService;
    private final TokenService tokenService;
    private UUID token;

    public WorldController(WorldService worldService, PlaceService placeService, TokenService tokenService) {
        this.worldService   = worldService;
        this.placeService   = placeService;
        this.tokenService   = tokenService;
    }

    @ModelAttribute
    public void setToken(@PathVariable String token) {
        this.token = UUID.fromString(token);
    }

    @GetMapping("/get")
    public ResponseEntity<String> getWorld(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(worldService.getWorld(id).toString());
            } else {
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.WORLD_NOT_FOUND.status).body(ServerStatus.WORLD_NOT_FOUND.toString());
        }
    }
    

    @GetMapping("/list")
    public ResponseEntity<String> listWorlds() {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(worldService.listWorlds().toString());
            } else {
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.WORLD_NOT_FOUND.status).body(ServerStatus.WORLD_NOT_FOUND.toString());
        }
    }

    @GetMapping("/places/get")
    public ResponseEntity<String> getPlace(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(placeService.getPlace(id).toString());
            } else {
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.PLACE_NOT_FOUND.status).body(ServerStatus.PLACE_NOT_FOUND.toString());
        }
    }

    @GetMapping("/places/listAll")
    public ResponseEntity<String> listPlaces() {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(placeService.listPlaces().toString());
            } else {
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.PLACE_NOT_FOUND.status).body(ServerStatus.PLACE_NOT_FOUND.toString());
        }
    }

    @GetMapping("/places/list")
    public ResponseEntity<String> listWorldPlaces(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(worldService.listWorldPlaces(id).toString());
            } else {
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.WORLD_NOT_FOUND.status).body(ServerStatus.WORLD_NOT_FOUND.toString());
        }
    }
}

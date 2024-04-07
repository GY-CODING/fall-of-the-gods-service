package com.gycoding.fallofthegods.controller;

import com.gycoding.fallofthegods.model.database.TokenService;
import com.gycoding.fallofthegods.model.entities.accounts.GYToken;
import org.springframework.web.bind.annotation.*;

import com.gycoding.fallofthegods.model.database.PlaceService;
import com.gycoding.fallofthegods.model.database.WorldService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;

@RestController
@RequestMapping("/{token}/worlds")
public class WorldRouting {
    private final WorldService worldService;
    private final PlaceService placeService;
    private final TokenService tokenService;
    private GYToken token;

    public WorldRouting(WorldService worldService, PlaceService placeService, TokenService tokenService) {
        this.worldService   = worldService;
        this.placeService   = placeService;
        this.tokenService   = tokenService;
    }

    @ModelAttribute
    public void setToken(@PathVariable String token) {
        this.token = new GYToken(token);
    }

    @GetMapping("/get")
    public String getWorld(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return worldService.getWorld(id).toString();
            } else {
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }
    

    @GetMapping("/list")
    public String listWorlds() {
        try {
            if(tokenService.checkToken(token)) {
                return worldService.listWorlds().toString();
            } else {
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/places/get")
    public String getPlace(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return placeService.getPlace(id).toString();
            } else {
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/places/listAll")
    public String listPlaces() {
        try {
            if(tokenService.checkToken(token)) {
                return placeService.listPlaces().toString();
            } else {
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/places/list")
    public String listWorldPlaces(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return worldService.listWorldPlaces(id).toString();
            } else {
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            return ServerStatus.NOT_FOUND.toString();
        }
    }
}

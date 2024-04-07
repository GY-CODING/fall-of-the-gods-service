package com.gycoding.fallofthegods.controller;

import com.gycoding.fallofthegods.model.database.TokenService;
import com.gycoding.fallofthegods.model.entities.accounts.GYToken;
import org.springframework.web.bind.annotation.*;

import com.gycoding.fallofthegods.model.database.CharacterService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.characters.EntityCharacter;

@RestController
@RequestMapping("/characters")
public class CharacterRouting {
    private final CharacterService characterService;
    private final TokenService tokenService;

    public CharacterRouting(CharacterService characterService, TokenService tokenService) {
        this.characterService = characterService;
        this.tokenService = tokenService;
    }

    @GetMapping("/story/get")
    public String getStoryCharacter(@RequestParam String id) {
        try {
            return characterService.getStoryCharacter(id).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/story/list")
    public String listStoryCharacters() {
        try {
            return characterService.listStoryCharacters().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/{token}/game/get")
    public String getGameCharacter(@PathVariable String token, @RequestParam String id) {
        try {
            if(tokenService.checkToken(new GYToken(token))) {
                return characterService.getGameCharacter(id).toString();
            } else {
                return "Invalid token";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/game/list")
    public String listGameCharacters() {
        try {
            return characterService.listGameCharacters().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ServerStatus.NOT_FOUND.toString();
        }
    }
}

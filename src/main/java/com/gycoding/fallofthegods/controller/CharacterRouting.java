package com.gycoding.fallofthegods.controller;

import com.gycoding.fallofthegods.model.database.TokenService;
import com.gycoding.fallofthegods.model.entities.accounts.GYToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gycoding.fallofthegods.model.database.CharacterService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.characters.EntityCharacter;

@RestController
@RequestMapping("/{token}/characters")
public class CharacterRouting {
    private final CharacterService characterService;
    private final TokenService tokenService;
    private GYToken token;

    public CharacterRouting(CharacterService characterService, TokenService tokenService) {
        this.characterService   = characterService;
        this.tokenService       = tokenService;
    }

    @ModelAttribute
    public void setToken(@PathVariable String token) {
        this.token = new GYToken(token);
    }

    @GetMapping("/story/get")
    public ResponseEntity<String> getStoryCharacter(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(characterService.getStoryCharacter(id).toString());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ServerStatus.INTERNAL_ERROR.toString());
        }
    }

    @GetMapping("/story/list")
    public String listStoryCharacters() {
        try {
            if(tokenService.checkToken(token)) {
                return characterService.listStoryCharacters().toString();
            } else {
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/game/get")
    public String getGameCharacter(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return characterService.getGameCharacter(id).toString();
            } else {
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ServerStatus.NOT_FOUND.toString();
        }
    }

    @GetMapping("/game/list")
    public String listGameCharacters() {
        try {
            if(tokenService.checkToken(token)) {
                return characterService.listGameCharacters().toString();
            } else {
                return ServerStatus.INVALID_TOKEN.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ServerStatus.NOT_FOUND.toString();
        }
    }
}

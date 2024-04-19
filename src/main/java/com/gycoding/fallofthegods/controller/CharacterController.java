package com.gycoding.fallofthegods.controller;

import com.gycoding.fallofthegods.model.database.service.CharacterService;
import com.gycoding.fallofthegods.model.database.service.TokenService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/{token}/characters")
public class CharacterController {
    private final CharacterService characterService;
    private final TokenService tokenService;
    private UUID token;

    public CharacterController(CharacterService characterService, TokenService tokenService) {
        this.characterService   = characterService;
        this.tokenService       = tokenService;
    }

    @ModelAttribute
    public void setToken(@PathVariable String token) {
        this.token = UUID.fromString(token);
    }

    @GetMapping("/story/get")
    public ResponseEntity<String> getStoryCharacter(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(characterService.getStoryCharacter(id).toString());
            } else {
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.CHARACTER_NOT_FOUND.status).body(ServerStatus.CHARACTER_NOT_FOUND.toString());
        }
    }

    @GetMapping("/story/list")
    public ResponseEntity<String> listStoryCharacters() {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(characterService.listStoryCharacters().toString());
            } else {
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.CHARACTER_NOT_FOUND.status).body(ServerStatus.CHARACTER_NOT_FOUND.toString());
        }
    }

    @GetMapping("/game/get")
    public ResponseEntity<String> getGameCharacter(@RequestParam String id) {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(characterService.getGameCharacter(id).toString());
            } else {
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.CHARACTER_NOT_FOUND.status).body(ServerStatus.CHARACTER_NOT_FOUND.toString());
        }
    }

    @GetMapping("/game/list")
    public ResponseEntity<String> listGameCharacters() {
        try {
            if(tokenService.checkToken(token)) {
                return ResponseEntity.ok(characterService.listGameCharacters().toString());
            } else {
                return ResponseEntity.status(ServerStatus.INVALID_TOKEN.status).body(ServerStatus.INVALID_TOKEN.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.CHARACTER_NOT_FOUND.status).body(ServerStatus.CHARACTER_NOT_FOUND.toString());
        }
    }
}

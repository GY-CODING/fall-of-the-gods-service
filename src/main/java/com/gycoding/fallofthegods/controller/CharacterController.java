package com.gycoding.fallofthegods.controller;

import com.gycoding.fallofthegods.model.database.service.CharacterService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/story/get")
    public ResponseEntity<String> getStoryCharacter(@RequestParam String id) {
        try {
            return ResponseEntity.ok(characterService.getStoryCharacter(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.CHARACTER_NOT_FOUND.status).body(ServerStatus.CHARACTER_NOT_FOUND.toString());
        }
    }

    @GetMapping("/story/list")
    public ResponseEntity<String> listStoryCharacters() {
        try {
            return ResponseEntity.ok(characterService.listStoryCharacters().toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.CHARACTER_NOT_FOUND.status).body(ServerStatus.CHARACTER_NOT_FOUND.toString());
        }
    }

    @GetMapping("/game/get")
    public ResponseEntity<String> getGameCharacter(@RequestParam String id) {
        try {
            return ResponseEntity.ok(characterService.getGameCharacter(id).toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.CHARACTER_NOT_FOUND.status).body(ServerStatus.CHARACTER_NOT_FOUND.toString());
        }
    }

    @GetMapping("/game/list")
    public ResponseEntity<String> listGameCharacters() {
        try {
            return ResponseEntity.ok(characterService.listGameCharacters().toString());
        } catch (Exception e) {
            return ResponseEntity.status(ServerStatus.CHARACTER_NOT_FOUND.status).body(ServerStatus.CHARACTER_NOT_FOUND.toString());
        }
    }
}

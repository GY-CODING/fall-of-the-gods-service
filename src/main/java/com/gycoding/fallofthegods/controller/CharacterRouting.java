package com.gycoding.fallofthegods.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gycoding.fallofthegods.model.database.CharacterService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/characters")
public class CharacterRouting {
    private final CharacterService characterService;

    public CharacterRouting(CharacterService characterService) {
        this.characterService = characterService;
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

    @GetMapping("/game/get")
    public String getGameCharacter(@RequestParam String id) {
        try {
            return characterService.getGameCharacter(id).toString();
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

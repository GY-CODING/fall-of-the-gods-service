package com.gycoding.fallofthegods.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gycoding.fallofthegods.model.database.CharacterService;

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

    @GetMapping("/get")
    public String getCharacter(@RequestParam int id) {
        return characterService.getCharacter(id).toString();
    }

    @GetMapping("/list")
    public String listCharacters() {
        return characterService.listCharacters().toString();
    }
}

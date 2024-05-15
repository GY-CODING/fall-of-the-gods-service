package com.gycoding.fallofthegods.controller.apimanagement;

import com.gycoding.fallofthegods.model.database.service.CharacterService;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters/manage")
public class CharacterManagementController {
    private final CharacterService characterService;

    public CharacterManagementController(CharacterService characterService) {
        this.characterService = characterService;
    }

    /**
     *
     * - Insert a new character.
     * - Update a character in its entirety.
     * - Update a character by world.
     * - Update a character by identifier.
     * - Update a character by race.
     * - Delete a character.
     *
     */
}

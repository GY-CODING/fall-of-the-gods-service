package com.gycoding.fallofthegods.model.database;

import com.gycoding.fallofthegods.model.entities.EntityCharacter;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @SuppressWarnings("null")
    public void insertCharacter(EntityCharacter character) {
        characterRepository.save(character);
    }

    public EntityCharacter getCharacter(int id) {
        EntityCharacter character = characterRepository.findAll().get(id);
        character.setID(id);
        return character;
    }

    public List<EntityCharacter> listCharacters() {
        return characterRepository.findAll();
    }
}

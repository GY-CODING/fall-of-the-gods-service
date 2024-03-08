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

    public EntityCharacter getStoryCharacter(String id) {
        return characterRepository.findByIdentifier(id).orElse(null);
    }

    public List<EntityCharacter> listStoryCharacters() {
        return characterRepository.findAll();
    }

    public EntityCharacter getGameCharacter(String id) {
        return characterRepository.findByIdentifierAndInGame(id, true).orElse(null);
    }

    public List<EntityCharacter> listGameCharacters() {
        return characterRepository.findByInGame(true).orElse(null);
    }
}

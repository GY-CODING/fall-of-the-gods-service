package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.CharacterRepository;
import com.gycoding.fallofthegods.model.entities.characters.EntityCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for the Character entity.
 * @see EntityCharacter
 * @see CharacterRepository
 * @see Service
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Service
public class CharacterService {
    @Autowired
    private final CharacterRepository characterRepository = null;

    /**
     * Finds a Character from the story by its identifier.
     * @param id
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityCharacter
     * @see CharacterRepository
     */
    public EntityCharacter getStoryCharacter(String id) {
        return characterRepository.findByIdentifier(id).orElse(null);
    }

    /**
     * Lists all characters from the story.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityCharacter
     * @see CharacterRepository
     */
    public List<EntityCharacter> listStoryCharacters() {
        return characterRepository.findAll();
    }

    /**
     * Finds a Character from the game by its identifier.
     * @param id
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityCharacter
     * @see CharacterRepository
     */
    public EntityCharacter getGameCharacter(String id) {
        return characterRepository.findByIdentifierAndInGame(id, true).orElse(null);
    }

    /**
     * Lists all characters from the game.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityCharacter
     * @see CharacterRepository
     */
    public List<EntityCharacter> listGameCharacters() {
        return characterRepository.findByInGame(true).orElse(null);
    }
}

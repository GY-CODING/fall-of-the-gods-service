package com.gycoding.fallofthegods.model.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gycoding.fallofthegods.model.entities.characters.EntityCharacter;

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
    
    @Autowired
    private final StoryService storyService = null;

    /**
     * Finds a Character from the story by its identifier.
     * @param id
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityCharacter
     * @see CharacterRepository
     */
    public EntityCharacter getStoryCharacter(String id) {
        EntityCharacter character = characterRepository.findByIdentifier(id).orElse(null);

        character.setStories(storyService.listStoriesByCharacter(id));

        return character;
    }

    /**
     * Lists all characters from the story.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityCharacter
     * @see CharacterRepository
     */
    public List<EntityCharacter> listStoryCharacters() {
        List<EntityCharacter> characters = characterRepository.findAll();

        for(EntityCharacter character : characters) {
            character.setStories(storyService.listStoriesByCharacter(character.getIdentifier()));
        }

        return characters;
    }

    /**
     * Finds a Character from the game by its identifier.
     * @param id
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityCharacter
     * @see CharacterRepository
     */
    public EntityCharacter getGameCharacter(String id) {
        EntityCharacter character = characterRepository.findByIdentifierAndInGame(id, true).orElse(null);

        character.setStories(storyService.listStoriesByCharacter(id));

        return character;
    }

    /**
     * Lists all characters from the game.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityCharacter
     * @see CharacterRepository
     */
    public List<EntityCharacter> listGameCharacters() {
        List<EntityCharacter> characters = characterRepository.findByInGame(true).orElse(null);

        for(EntityCharacter character : characters) {
            character.setStories(storyService.listStoriesByCharacter(character.getIdentifier()));
        }

        return characters;
    }
}

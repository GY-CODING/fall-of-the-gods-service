package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.CharacterRepository;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.characters.EntityCharacter;
import com.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
     * @return EntityCharacter
     * @param id
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityCharacter
     * @see CharacterRepository
     * @throws FOTGAPIException
     */
    public EntityCharacter getStoryCharacter(String id) throws FOTGAPIException {
        return characterRepository.findByIdentifier(id).orElseThrow(() ->
            new FOTGAPIException(ServerStatus.CHARACTER_NOT_FOUND)
        );
    }

    /**
     * Lists all characters from the story.
     * @return List of EntityCharacter
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityCharacter
     * @see CharacterRepository
     * @throws FOTGAPIException
     */
    public List<EntityCharacter> listStoryCharacters() throws FOTGAPIException {
        try {
            return characterRepository.findAll();
        } catch(NullPointerException e) {
            throw new FOTGAPIException(ServerStatus.LIST_CHARACTER_NOT_FOUND);
        }
    }

    /**
     * Lists all characters from the story with pagination.
     * @return List of EntityCharacter
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Map
     * @see Pageable
     * @see Page
     * @see EntityCharacter
     * @see CharacterRepository
     * @throws FOTGAPIException
     */
    public Page<Map<String, Object>> pageStoryCharacters(Pageable pageable) throws FOTGAPIException {
        try {
            return characterRepository.findAll(pageable)
                    .map(EntityCharacter::toMap);
        } catch(NullPointerException e) {
            throw new FOTGAPIException(ServerStatus.LIST_CHARACTER_NOT_FOUND);
        }
    }

    /**
     * Finds a Character from the game by its identifier.
     * @param id
     * @return EntityCharacter
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityCharacter
     * @see CharacterRepository
     * @throws FOTGAPIException
     */
    public EntityCharacter getGameCharacter(String id) throws FOTGAPIException {
        return characterRepository.findByIdentifierAndInGame(id, true).orElseThrow(() ->
            new FOTGAPIException(ServerStatus.CHARACTER_NOT_FOUND)
        );
    }

    /**
     * Lists all characters from the game.
     * @return List of EntityCharacter
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityCharacter
     * @see CharacterRepository
     * @throws FOTGAPIException
     */
    public List<EntityCharacter> listGameCharacters() throws FOTGAPIException {
        return characterRepository.findByInGame(true).orElseThrow(() ->
            new FOTGAPIException(ServerStatus.LIST_CHARACTER_NOT_FOUND)
        );
    }

    /**
     * Lists all characters from the game with pagination.
     * @return List of EntityCharacter
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Map
     * @see Pageable
     * @see Page
     * @see EntityCharacter
     * @see CharacterRepository
     * @throws FOTGAPIException
     */
    public Page<Map<String, Object>> pageGameCharacters(Pageable pageable) throws FOTGAPIException {
        final var characters = characterRepository.findByInGame(true, pageable).orElseThrow(() ->
            new FOTGAPIException(ServerStatus.LIST_CHARACTER_NOT_FOUND)
        );

        return characters.map(EntityCharacter::toMap);
    }
}

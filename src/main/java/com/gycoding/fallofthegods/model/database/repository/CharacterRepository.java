package com.gycoding.fallofthegods.model.database.repository;

import com.gycoding.fallofthegods.model.entities.characters.EntityCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the Character entity.
 * @see EntityCharacter
 * @see MongoRepository
 * @see Repository
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Repository
public interface CharacterRepository extends MongoRepository<EntityCharacter, String> {
    /**
     * Finds a Character by its identifier.
     * @param identifier
     * @return EntityCharacter
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Optional
     * @see EntityCharacter
     */
    Optional<EntityCharacter> findByIdentifier(String identifier);

    /**
     * Finds a Character by its identifier and inGame parameter.
     * @param identifier
     * @param inGame
     * @return EntityCharacter
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Optional
     * @see EntityCharacter
     */
    Optional<EntityCharacter> findByIdentifierAndInGame(String identifier, Boolean inGame);

    /**
     * Lists all characters filtered by their inGame parameters.
     * @param inGame
     * @return List of EntityCharacter
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Optional
     * @see List
     * @see EntityCharacter
     */
    Optional<List<EntityCharacter>> findByInGame(Boolean inGame);
}

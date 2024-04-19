package com.gycoding.fallofthegods.model.database.repository;

import com.gycoding.fallofthegods.model.entities.items.EntityItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the Item entity.
 * @see EntityItem
 * @see MongoRepository
 * @see Repository 
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Repository
public interface ItemRepository extends MongoRepository<EntityItem, String> {
    /**
     * Finds an Item by its identifier.
     * @param identifier
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Optional
     * @see EntityItem
     */
    Optional<EntityItem> findByIdentifier(String identifier);

    /**
     * Finds an Item by its identifier and its inGame parameter.
     * @param identifier
     * @param inGame
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Optional
     * @see EntityItem
     */
    Optional<EntityItem> findByIdentifierAndInGame(String identifier, Boolean inGame);
    
    /**
     * Lists all items filtred by their inGame parameters.
     * @param inGame
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Optional
     * @see List
     * @see EntityItem
     */
    Optional<List<EntityItem>> findByInGame(Boolean inGame);
}

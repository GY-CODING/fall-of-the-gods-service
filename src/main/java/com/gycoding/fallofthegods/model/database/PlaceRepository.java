package com.gycoding.fallofthegods.model.database;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gycoding.fallofthegods.model.entities.characters.EntityStory;
import com.gycoding.fallofthegods.model.entities.worlds.EntityPlace;

/**
 * Repository for the Place entity.
 * @see EntityPlace
 * @see MongoRepository
 * @see Repository
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Repository
public interface PlaceRepository extends MongoRepository<EntityPlace, String> {
    /**
     * Finds a Place by its identifier.
     * @param identifier
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Optional
     * @see EntityPlace
     */
    Optional<EntityPlace> findByIdentifier(String identifier);
}

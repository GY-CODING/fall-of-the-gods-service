package org.gycoding.fallofthegods.model.database.repository;

import org.gycoding.fallofthegods.model.entities.worlds.EntityPlace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends MongoRepository<EntityPlace, String> {
    Optional<EntityPlace> findByIdentifier(String identifier);
}

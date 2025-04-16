package org.gycoding.fallofthegods.infrastructure.external.database.repository;

import org.gycoding.fallofthegods.infrastructure.external.database.model.worlds.PlaceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceMongoRepository extends MongoRepository<PlaceEntity, String> {
    Optional<PlaceEntity> findByIdentifier(String identifier);

    void removeByIdentifier(String identifier);
}

package org.gycoding.fallofthegods.infrastructure.external.database.repository;

import org.gycoding.fallofthegods.infrastructure.external.database.model.creatures.CreatureEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreatureMongoRepository extends MongoRepository<CreatureEntity, String> {
    Optional<CreatureEntity> findByIdentifier(String identifier);

    void removeByIdentifier(String identifier);
}

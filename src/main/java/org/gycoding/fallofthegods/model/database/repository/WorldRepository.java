package org.gycoding.fallofthegods.model.database.repository;

import org.gycoding.fallofthegods.model.entities.worlds.EntityWorld;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorldRepository extends MongoRepository<EntityWorld, String> {
    Optional<EntityWorld> findByIdentifier(String identifier);
}

package org.gycoding.heraldsofchaos.infrastructure.external.database.repository;

import org.gycoding.heraldsofchaos.infrastructure.external.database.model.worlds.WorldEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorldMongoRepository extends MongoRepository<WorldEntity, String> {
    Optional<WorldEntity> findByIdentifier(String identifier);

    void removeByIdentifier(String identifier);
}

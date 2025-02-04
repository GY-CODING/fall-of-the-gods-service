package org.gycoding.fallofthegods.infrastructure.external.database.repository;

import org.gycoding.fallofthegods.infrastructure.external.database.model.worlds.WorldEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorldMongoRepository extends MongoRepository<WorldEntity, String> {
    Optional<WorldEntity> findByIdentifier(String identifier);

    void removeByIdentifier(String identifier);
}

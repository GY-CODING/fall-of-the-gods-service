package org.gycoding.fallofthegods.infrastructure.external.database.repository;

import org.gycoding.fallofthegods.infrastructure.external.database.model.creatures.CreatureEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreatureMongoRepository extends MongoRepository<CreatureEntity, String> {
    Optional<CreatureEntity> findByIdentifier(String identifier);

    Optional<CreatureEntity> findByIdentifierAndInGame(String identifier, Boolean inGame);

    List<CreatureEntity> findByInGame(Boolean inGame);

    Page<CreatureEntity> findByInGame(Boolean inGame, Pageable pageable);

    void removeByIdentifier(String identifier);
}

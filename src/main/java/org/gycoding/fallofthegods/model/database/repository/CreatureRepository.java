package org.gycoding.fallofthegods.model.database.repository;

import org.gycoding.fallofthegods.model.entities.creatures.EntityCreature;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreatureRepository extends MongoRepository<EntityCreature, String> {
    Optional<EntityCreature> findByIdentifier(String identifier);

    Optional<EntityCreature> findByIdentifierAndInGame(String identifier, Boolean inGame);

    Optional<List<EntityCreature>> findByInGame(Boolean inGame);

    Optional<Page<EntityCreature>> findByInGame(Boolean inGame, Pageable pageable);
}

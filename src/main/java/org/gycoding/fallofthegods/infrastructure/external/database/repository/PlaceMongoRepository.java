package org.gycoding.fallofthegods.infrastructure.external.database.repository;

import org.gycoding.fallofthegods.infrastructure.external.database.model.worlds.PlaceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceMongoRepository extends MongoRepository<PlaceEntity, String> {
    Optional<PlaceEntity> findByIdentifier(String identifier);

    Optional<PlaceEntity> findByIdentifierAndInGame(String identifier, Boolean inGame);

    List<PlaceEntity> findByInGame(Boolean inGame);

    Page<PlaceEntity> findByInGame(Boolean inGame, Pageable pageable);

    void removeByIdentifier(String identifier);
}

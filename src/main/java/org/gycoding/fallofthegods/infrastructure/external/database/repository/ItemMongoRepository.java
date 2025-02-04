package org.gycoding.fallofthegods.infrastructure.external.database.repository;

import org.gycoding.fallofthegods.infrastructure.external.database.model.items.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemMongoRepository extends MongoRepository<ItemEntity, String> {
    Optional<ItemEntity> findByIdentifier(String identifier);

    Optional<ItemEntity> findByIdentifierAndInGame(String identifier, Boolean inGame);

    List<ItemEntity> findByInGame(Boolean inGame);

    Page<ItemEntity> findByInGame(Boolean inGame, Pageable pageable);

    void removeByIdentifier(String identifier);
}

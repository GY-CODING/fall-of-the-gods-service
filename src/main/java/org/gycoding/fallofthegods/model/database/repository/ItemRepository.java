package org.gycoding.fallofthegods.model.database.repository;

import org.gycoding.fallofthegods.model.entities.items.EntityItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<EntityItem, String> {
    Optional<EntityItem> findByIdentifier(String identifier);

    Optional<EntityItem> findByIdentifierAndInGame(String identifier, Boolean inGame);

    Optional<List<EntityItem>> findByInGame(Boolean inGame);

    Optional<Page<EntityItem>> findByInGame(Boolean inGame, Pageable pageable);
}

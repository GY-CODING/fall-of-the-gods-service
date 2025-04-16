package org.gycoding.fallofthegods.infrastructure.external.database.repository;

import org.gycoding.fallofthegods.infrastructure.external.database.model.items.ItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemMongoRepository extends MongoRepository<ItemEntity, String> {
    Optional<ItemEntity> findByIdentifier(String identifier);

    void removeByIdentifier(String identifier);
}

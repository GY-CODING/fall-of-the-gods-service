package com.gycoding.fallofthegods.model.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gycoding.fallofthegods.model.entities.EntityItem;

@Repository
public interface ItemRepository extends MongoRepository<EntityItem, String>{
    Optional<EntityItem> findByIdentifier(String identifier);
    Optional<EntityItem> findByIdentifierAndInGame(String identifier, Boolean inGame);
    Optional<List<EntityItem>> findByInGame(Boolean inGame);
}

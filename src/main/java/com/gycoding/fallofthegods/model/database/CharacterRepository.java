package com.gycoding.fallofthegods.model.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gycoding.fallofthegods.model.entities.EntityCharacter;

@Repository
public interface CharacterRepository extends MongoRepository<EntityCharacter, String>{
    Optional<EntityCharacter> findByIdentifier(String identifier);
    Optional<EntityCharacter> findByIdentifierAndInGame(String identifier, Boolean inGame);
    Optional<List<EntityCharacter>> findByInGame(Boolean inGame);
}

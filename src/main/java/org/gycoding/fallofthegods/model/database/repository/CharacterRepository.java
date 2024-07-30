package org.gycoding.fallofthegods.model.database.repository;

import org.gycoding.fallofthegods.model.entities.characters.EntityCharacter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends MongoRepository<EntityCharacter, String> {
    Optional<EntityCharacter> findByIdentifier(String identifier);

    Optional<EntityCharacter> findByIdentifierAndInGame(String identifier, Boolean inGame);

    Optional<List<EntityCharacter>> findByInGame(Boolean inGame);

    Optional<Page<EntityCharacter>> findByInGame(Boolean inGame, Pageable pageable);
}

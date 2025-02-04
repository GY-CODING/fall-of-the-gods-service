package org.gycoding.fallofthegods.infrastructure.external.database.repository;

import org.gycoding.fallofthegods.infrastructure.external.database.model.characters.CharacterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterMongoRepository extends MongoRepository<CharacterEntity, String> {
    Optional<CharacterEntity> findByIdentifier(String identifier);

    Optional<CharacterEntity> findByIdentifierAndInGame(String identifier, Boolean inGame);

    List<CharacterEntity> findByInGame(Boolean inGame);

    Page<CharacterEntity> findByInGame(Boolean inGame, Pageable pageable);

    void removeByIdentifier(String identifier);
}

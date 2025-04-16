package org.gycoding.heraldsofchaos.infrastructure.external.database.repository;

import org.gycoding.heraldsofchaos.infrastructure.external.database.model.characters.CharacterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterMongoRepository extends MongoRepository<CharacterEntity, String> {
    Optional<CharacterEntity> findByIdentifier(String identifier);

    void removeByIdentifier(String identifier);
}

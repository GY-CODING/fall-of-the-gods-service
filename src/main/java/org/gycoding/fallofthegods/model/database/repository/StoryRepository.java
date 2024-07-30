package org.gycoding.fallofthegods.model.database.repository;

import org.gycoding.fallofthegods.model.entities.characters.EntityStory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoryRepository extends MongoRepository<EntityStory, String> {
    Optional<EntityStory> findByIdentifier(String identifier);
}

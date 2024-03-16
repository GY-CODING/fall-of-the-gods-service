package com.gycoding.fallofthegods.model.database;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gycoding.fallofthegods.model.entities.characters.EntityStory;

@Repository
public interface StoryRepository extends MongoRepository<EntityStory, String>{
    Optional<EntityStory> findByIdentifier(String identifier);
}

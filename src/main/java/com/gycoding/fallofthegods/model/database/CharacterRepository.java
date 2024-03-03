package com.gycoding.fallofthegods.model.database;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gycoding.fallofthegods.model.entities.EntityCharacter;

@Repository
public interface CharacterRepository extends MongoRepository<EntityCharacter, String>{
    
}

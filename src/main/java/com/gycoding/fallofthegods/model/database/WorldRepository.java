package com.gycoding.fallofthegods.model.database;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gycoding.fallofthegods.model.entities.Worlds.EntityWorld;

@Repository
public interface WorldRepository extends MongoRepository<EntityWorld, String>{
    Optional<EntityWorld> findByIdentifier(String identifier);
}

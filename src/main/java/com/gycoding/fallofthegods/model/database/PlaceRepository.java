package com.gycoding.fallofthegods.model.database;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gycoding.fallofthegods.model.entities.worlds.EntityPlace;

@Repository
public interface PlaceRepository extends MongoRepository<EntityPlace, String>{
    Optional<EntityPlace> findByIdentifier(String identifier);
}

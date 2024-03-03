package com.gycoding.fallofthegods.model.database;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gycoding.fallofthegods.model.entities.EntityWorld;

@Repository
public interface WorldRepository extends MongoRepository<EntityWorld, String>{
    
}

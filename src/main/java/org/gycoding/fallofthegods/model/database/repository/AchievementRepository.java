package org.gycoding.fallofthegods.model.database.repository;


import org.gycoding.fallofthegods.model.entities.achievements.EntityAchievement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AchievementRepository extends MongoRepository<EntityAchievement, String>{
    Optional<EntityAchievement> findByIdentifier(String identifier);
}

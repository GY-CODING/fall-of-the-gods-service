package com.gycoding.fallofthegods.model.database.repository;


import com.gycoding.fallofthegods.model.entities.achievements.EntityAchievement;
import com.gycoding.fallofthegods.model.entities.characters.EntityStory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for the Achievement entity.
 * @see EntityAchievement
 * @see MongoRepository
 * @see Repository
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Repository
public interface AchievementRepository extends MongoRepository<EntityAchievement, String>{

    /**
     * Finds an Achievement by its identifier.
     * @param identifier
     * @return EntityAchievement
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Optional
     * @see EntityAchievement
     */
    EntityAchievement findByIdentifier(String identifier);
}

package com.gycoding.fallofthegods.model.database.repository;


import com.gycoding.fallofthegods.model.entities.achievements.EntityAchievement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the Achievement entity.
 * @see EntityAchievement
 * @see MongoRepository
 * @see Repository
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Repository
public interface AchievementRepository extends MongoRepository<EntityAchievement, String>{
}

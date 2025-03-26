package org.gycoding.heraldsofchaos.infrastructure.external.database.repository;

import org.gycoding.heraldsofchaos.infrastructure.external.database.model.achievements.AchievementEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AchievementMongoRepository extends MongoRepository<AchievementEntity, String> {
    Optional<AchievementEntity> findByIdentifier(String identifier);

    void removeByIdentifier(String identifier);
}

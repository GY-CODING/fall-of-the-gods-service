package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.AchievementRepository;
import com.gycoding.fallofthegods.model.database.repository.StoryRepository;
import com.gycoding.fallofthegods.model.entities.achievements.EntityAchievement;
import com.gycoding.fallofthegods.model.entities.characters.EntityStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AchievementService {
    @Autowired
    private AchievementRepository achievementRepository;

    /**
     * Finds an Achievement by its identifier.
     * @param identifier
     * @return EntityAchievement
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityAchievement
     * @see AchievementRepository
     */
    public EntityAchievement getAchievement(String identifier) {
        return achievementRepository.findByIdentifier(identifier);
    }

    /**
     * Lists all the Achievements.
     * @return List of EntityAchievement
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityAchievement
     * @see AchievementRepository
     */
    public Page<Map<String, Object>> listAchievements(Pageable pageable) {
        return achievementRepository.findAll(pageable)
                .map(EntityAchievement::toMap);
    }
}

package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.AchievementRepository;
import com.gycoding.fallofthegods.model.database.repository.StoryRepository;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.achievements.EntityAchievement;
import com.gycoding.fallofthegods.model.entities.characters.EntityStory;
import com.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIException;
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
     * @throws FOTGAPIException
     */
    public EntityAchievement getAchievement(String identifier) throws FOTGAPIException {
        return achievementRepository.findByIdentifier(identifier).orElseThrow(() ->
                new FOTGAPIException(ServerStatus.ACHIEVEMENT_NOT_FOUND)
        );
    }

    /**
     * Lists all the Achievements.
     * @return List of EntityAchievement
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityAchievement
     * @see AchievementRepository
     * @throws FOTGAPIException
     */
    public List<EntityAchievement> listAchievements() throws FOTGAPIException {
        try {
            return achievementRepository.findAll();
        } catch (NullPointerException e) {
            throw new FOTGAPIException(ServerStatus.LIST_ACHIEVEMENT_NOT_FOUND);
        }
    }

    /**
     * Lists all the Achievements with pagination.
     * @return List of EntityAchievement
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Pageable
     * @see Page
     * @see EntityAchievement
     * @see AchievementRepository
     * @throws FOTGAPIException
     */
    public Page<Map<String, Object>> pageAchievements(Pageable pageable) throws FOTGAPIException {
        try {
            return achievementRepository.findAll(pageable)
                    .map(EntityAchievement::toMap);
        } catch (NullPointerException e) {
            throw new FOTGAPIException(ServerStatus.LIST_ACHIEVEMENT_NOT_FOUND);
        }
    }
}

package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.fallofthegods.model.database.repository.AchievementRepository;
import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.model.entities.achievements.EntityAchievement;
import org.gycoding.springexceptions.model.APIException;
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

    public EntityAchievement getAchievement(String identifier) throws APIException {
        return achievementRepository.findByIdentifier(identifier).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.ACHIEVEMENT_NOT_FOUND.code,
                        FOTGAPIError.ACHIEVEMENT_NOT_FOUND.message,
                        FOTGAPIError.ACHIEVEMENT_NOT_FOUND.status
                )
        );
    }

    public List<EntityAchievement> listAchievements() throws APIException {
        try {
            return achievementRepository.findAll();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_ACHIEVEMENT_NOT_FOUND.code,
                    FOTGAPIError.LIST_ACHIEVEMENT_NOT_FOUND.message,
                    FOTGAPIError.LIST_ACHIEVEMENT_NOT_FOUND.status
            );
        }
    }

    public Page<Map<String, Object>> pageAchievements(Pageable pageable) throws APIException {
        try {
            return achievementRepository.findAll(pageable)
                    .map(EntityAchievement::toMap);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_ACHIEVEMENT_NOT_FOUND.code,
                    FOTGAPIError.LIST_ACHIEVEMENT_NOT_FOUND.message,
                    FOTGAPIError.LIST_ACHIEVEMENT_NOT_FOUND.status
            );
        }
    }
}

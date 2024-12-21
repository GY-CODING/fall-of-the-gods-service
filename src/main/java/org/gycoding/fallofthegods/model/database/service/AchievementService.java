package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.fallofthegods.model.database.repository.AchievementRepository;
import org.gycoding.fallofthegods.model.dto.achievements.AchievementRSDTO;
import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.model.entities.achievements.EntityAchievement;
import org.gycoding.exceptions.model.APIException;
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

    public AchievementRSDTO getAchievement(String identifier, String language) throws APIException {
        final var achievementEntity = achievementRepository.findByIdentifier(identifier).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return AchievementRSDTO.builder()
                .identifier(achievementEntity.identifier())
                .name(achievementEntity.name().get(language))
                .description(achievementEntity.description().get(language))
                .image(achievementEntity.image())
                .tier(achievementEntity.tier())
                .build();
    }

    public List<AchievementRSDTO> listAchievements(String language) throws APIException {
        try {
            final var achievementEntities = achievementRepository.findAll();

            return achievementEntities.stream().map(achievementEntity ->
                AchievementRSDTO.builder()
                    .identifier(achievementEntity.identifier())
                    .name(achievementEntity.name().get(language))
                    .description(achievementEntity.description().get(language))
                    .image(achievementEntity.image())
                    .tier(achievementEntity.tier())
                    .build()).toList();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }

    public Page<Map<String, Object>> pageAchievements(Pageable pageable, String language) throws APIException {
        try {
            final var achievementEntities = achievementRepository.findAll(pageable);

            return achievementEntities.map(achievementEntity ->
                    AchievementRSDTO.builder()
                            .identifier(achievementEntity.identifier())
                            .name(achievementEntity.name().get(language))
                            .description(achievementEntity.description().get(language))
                            .image(achievementEntity.image())
                            .tier(achievementEntity.tier())
                            .build().toMap()
            );
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }
}

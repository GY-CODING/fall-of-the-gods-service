package org.gycoding.fallofthegods.infrastructure.api.dto.out.achievements;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementOrigin;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementTier;

import java.util.Map;

@Builder
public record AchievementRSDTO(
    String identifier,
    String name,
    String description,
    String image,
    AchievementTier tier,
    AchievementOrigin origin
) { }
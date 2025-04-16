package org.gycoding.fallofthegods.application.dto.in.achievements;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementOrigin;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementTier;

@Builder
public record AchievementIDTO(
    String identifier,
    TranslatedString name,
    TranslatedString description,
    String image,
    AchievementTier tier,
    AchievementOrigin origin
) {}

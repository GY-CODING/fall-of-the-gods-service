package org.gycoding.heraldsofchaos.application.dto.in.achievements;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.achievements.AchievementOrigin;
import org.gycoding.heraldsofchaos.domain.model.achievements.AchievementTier;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

@Builder
public record AchievementIDTO(
    String identifier,
    TranslatedString name,
    TranslatedString description,
    String image,
    AchievementTier tier,
    AchievementOrigin origin
) {}

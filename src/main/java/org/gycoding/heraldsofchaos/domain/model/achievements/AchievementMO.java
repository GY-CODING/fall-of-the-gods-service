package org.gycoding.heraldsofchaos.domain.model.achievements;

import lombok.Builder;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

@Builder
public record AchievementMO(
    String identifier,
    TranslatedString name,
    TranslatedString description,
    String image,
    AchievementTier tier,
    AchievementOrigin origin
) { }

package org.gycoding.heraldsofchaos.infrastructure.external.database.model.achievements;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.achievements.AchievementOrigin;
import org.gycoding.heraldsofchaos.domain.model.achievements.AchievementTier;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "Achievement")
public record AchievementEntity(
    @Id
    String mongoId,
    String identifier,
    TranslatedString name,
    TranslatedString description,
    String image,
    AchievementTier tier,
    AchievementOrigin origin
) {}

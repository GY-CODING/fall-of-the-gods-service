package org.gycoding.fallofthegods.infrastructure.api.dto.in.achievements;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementOrigin;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementTier;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

import java.util.Map;

@Builder
public record AchievementRQDTO(
    String identifier,
    TranslatedString name,
    TranslatedString description,
    String image,
    AchievementTier tier,
    AchievementOrigin origin
) {
    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"image\": \"" + image + "\"," +
                "\"tier\": \"" + tier + "\"" +
                "\"origin\": \"" + origin + "\"" +
                "}";
    }

    public Map<String, Object> toMap() {
        return Map.of(
            "identifier", identifier,
            "name", name,
            "description", description,
            "image", image,
            "tier", tier,
            "origin", origin
        );
    }
}

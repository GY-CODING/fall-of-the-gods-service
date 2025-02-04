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
) {
    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"image\": \"" + image + "\"," +
                "\"tier\": \"" + tier + "\"" +
                "origin\": \"" + origin + "\"" +
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

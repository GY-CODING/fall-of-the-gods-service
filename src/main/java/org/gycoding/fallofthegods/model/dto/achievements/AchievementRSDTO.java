package org.gycoding.fallofthegods.model.dto.achievements;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.TranslatedString;
import org.gycoding.fallofthegods.model.entities.achievements.AchievementTiers;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Builder
public record AchievementRSDTO(
    String identifier,
    String name,
    String description,
    String image,
    AchievementTiers tier
) {
    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"image\": \"" + image + "\"," +
                "\"tier\": \"" + tier + "\"" +
                "}";
    }

    public Map<String, Object> toMap() {
        return Map.of(
            "identifier", identifier,
            "name", name,
            "description", description,
            "image", image,
            "tier", tier
        );
    }
}

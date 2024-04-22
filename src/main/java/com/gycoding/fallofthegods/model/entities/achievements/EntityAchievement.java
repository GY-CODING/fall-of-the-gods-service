package com.gycoding.fallofthegods.model.entities.achievements;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "Achievement")
public record EntityAchievement(
    @Id
    String mongoId,
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
}

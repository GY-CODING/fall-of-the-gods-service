package org.gycoding.fallofthegods.infrastructure.external.database.model.achievements;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementOrigin;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementTier;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Achievement")
public class AchievementEntity {
    @Id
    public String mongoId;
    public String identifier;
    public TranslatedString name;
    public TranslatedString description;
    public String image;
    public AchievementTier tier;
    public AchievementOrigin origin;

    @Builder
    public AchievementEntity(String mongoId, String identifier, TranslatedString name, TranslatedString description, String image, AchievementTier tier, AchievementOrigin origin) {
        this.mongoId = mongoId;
        this.identifier = identifier;
        this.name = name;
        this.description = description;
        this.image = image;
        this.tier = tier;
        this.origin = origin;
    }
}
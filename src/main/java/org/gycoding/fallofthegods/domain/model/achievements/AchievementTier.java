package org.gycoding.fallofthegods.domain.model.achievements;

import lombok.Getter;

@Getter
public enum AchievementTier {
    BRONZE("BRONZE"),
    SILVER("SILVER"),
    GOLD("GOLD"),
    PLATINUM("PLATINUM");

    public final String tier;

    private AchievementTier(String tier) {
        this.tier    = tier;
    }
}

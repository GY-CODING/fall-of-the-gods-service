package org.gycoding.fallofthegods.model.entities.achievements;

import lombok.Getter;

public enum AchievementTiers {
    BRONZE("BRONZE"),
    SILVER("SILVER"),
    GOLD("GOLD"),
    PLATINUM("PLATINUM");

    @Getter
    public final String tier;

    private AchievementTiers(String tier) {
        this.tier    = tier;
    }
}

package com.gycoding.fallofthegods.model.entities.characters;

import lombok.Builder;

@Builder
public record EntityAbility(
        String abilityName,
        String abilityDesc
) {
    @Override
    public String toString() {
        return "{" +
                "\"abilityName\": \"" + abilityName + "\"," +
                "\"abilityDesc\": \"" + abilityDesc + "\"" +
                "}";
    }
}

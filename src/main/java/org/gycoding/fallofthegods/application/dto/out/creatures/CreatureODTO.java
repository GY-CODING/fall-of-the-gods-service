package org.gycoding.fallofthegods.application.dto.out.creatures;

import lombok.Builder;

import java.util.Map;

@Builder
public record CreatureODTO(
        String identifier,
        String name,
        String description,
        Boolean inGame,
        String image
) {
    public Map<String, Object> toMap() {
        return new java.util.HashMap<>(Map.of(
                "identifier", identifier,
                "name", name,
                "description", description,
                "image", image
        ));
    }
}


package org.gycoding.fallofthegods.infrastructure.api.dto.out.creatures;

import lombok.Builder;

import java.util.Map;

@Builder
public record CreatureRSDTO(
        String identifier,
        String name,
        String description,
        Boolean inGame,
        String image
) {
    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"image\": \"" + image + "\"" +
                "}";
    }

    public Map<String, Object> toMap() {
        return new java.util.HashMap<>(Map.of(
                "identifier", identifier,
                "name", name,
                "description", description,
                "image", image
        ));
    }
}


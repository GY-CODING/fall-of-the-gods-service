package org.gycoding.fallofthegods.infrastructure.api.dto.out.worlds;

import lombok.Builder;

import java.util.Map;

@Builder
public record PlaceRSDTO(
        String identifier,
        String name,
        String description,
        String image,
        Boolean inGame
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
        return Map.of(
                "identifier", identifier,
                "name", name,
                "description", description,
                "image", image
        );
    }
}

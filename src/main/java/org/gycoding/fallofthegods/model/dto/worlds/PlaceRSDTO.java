package org.gycoding.fallofthegods.model.dto.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.TranslatedString;

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

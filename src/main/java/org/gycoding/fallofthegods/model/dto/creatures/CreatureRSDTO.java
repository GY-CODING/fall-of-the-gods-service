package org.gycoding.fallofthegods.model.dto.creatures;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.TranslatedString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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


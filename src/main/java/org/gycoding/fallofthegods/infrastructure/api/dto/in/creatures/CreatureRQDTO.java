package org.gycoding.fallofthegods.infrastructure.api.dto.in.creatures;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

import java.util.Map;

@Builder
public record CreatureRQDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
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


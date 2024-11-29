package org.gycoding.fallofthegods.model.dto.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.TranslatedString;

@Builder
public record AttributeRSDTO(
        String name,
        String description,
        String identifier
) {
    @Override
    public String toString() {
        return "{" +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"" +
                "\"identifier\": \"" + identifier + "\"" +
                "}";
    }
}

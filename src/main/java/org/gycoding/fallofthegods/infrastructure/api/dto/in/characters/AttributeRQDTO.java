package org.gycoding.fallofthegods.infrastructure.api.dto.in.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

@Builder
public record AttributeRQDTO(
        TranslatedString name,
        TranslatedString description,
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

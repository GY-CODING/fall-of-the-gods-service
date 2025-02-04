package org.gycoding.fallofthegods.infrastructure.api.dto.out.characters;

import lombok.Builder;

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

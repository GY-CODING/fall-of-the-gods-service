package org.gycoding.fallofthegods.application.dto.out.characters;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public record CharacterODTO(
        String identifier,
        String name,
        String title,
        String description,
        String world,
        String image,
        String race
) {
    public Map<String, Object> toMap() {
        return new HashMap<String, Object>(Map.of(
                "identifier", identifier,
                "name", name,
                "title", title,
                "description", description,
                "world", world,
                "race", race,
                "image", image
        ));
    }
}


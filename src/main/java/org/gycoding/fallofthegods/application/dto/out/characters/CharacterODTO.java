package org.gycoding.fallofthegods.application.dto.out.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.application.dto.out.worlds.WorldODTO;

import java.util.HashMap;
import java.util.Map;

@Builder
public record CharacterODTO(
        String identifier,
        String name,
        String title,
        String description,
        String world,
        Boolean inGame,
        String image,
        String race
) {
    public Map<String, Object> toMap() {
        final var map = new HashMap<String, Object>(Map.of(
                "identifier", identifier,
                "name", name,
                "title", title,
                "description", description,
                "world", world,
                "inGame", inGame,
                "race", race,
                "image", image
        ));

        return map;
    }
}


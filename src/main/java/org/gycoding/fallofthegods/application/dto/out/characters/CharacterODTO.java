package org.gycoding.fallofthegods.application.dto.out.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.application.dto.out.StatODTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.WorldODTO;
import org.gycoding.fallofthegods.domain.model.StatMO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Builder
public record CharacterODTO(
        String identifier,
        String name,
        String title,
        String description,
        WorldODTO world,
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
                "world", world != null ? world.identifier() : "null",
                "inGame", inGame,
                "race", race,
                "image", image
        ));

        return map;
    }
}


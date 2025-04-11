package org.gycoding.fallofthegods.infrastructure.api.dto.out.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.StatMO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.StatRSDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.worlds.WorldRSDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Builder
public record CharacterRSDTO(
        String identifier,
        String name,
        String title,
        String description,
        String world,
        Boolean inGame,
        String image,
        String race
) {
    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"title\": \"" + title + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"world\": \"" + world + "\"," +
                "\"race\": \"" + race + "\"," +
                "\"image\": \"" + image + "\"" +
                "}";
    }

    public Map<String, Object> toMap() {
        final var map = new HashMap<String, Object>(Map.of(
                "identifier", identifier,
                "name", name,
                "title", title,
                "description", description,
                "world", world,
                "race", race,
                "image", image
        ));

        return map;
    }
}


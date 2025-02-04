package org.gycoding.fallofthegods.infrastructure.api.dto.out.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.StatMO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.StatRSDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.worlds.WorldRSDTO;

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
        StatRSDTO<Double> stats,
        List<AbilityRSDTO> abilities,
        String race,
        List<AttributeRSDTO> attributes
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
                "\"image\": \"" + image + "\"," +
                "\"stats\": " + stats + "," +
                "\"abilities\": " + abilities + "," +
                "\"attributes\": " + attributes +
                "}";
    }

    public Map<String, Object> toMap() {
        final var map = new java.util.HashMap<>(Map.of(
                "identifier", identifier,
                "name", name,
                "title", title,
                "description", description,
                "world", world,
                "race", race,
                "image", image,
                "stats", stats,
                "abilities", abilities.isEmpty() ? abilities : List.of()
        ));

        map.put("attributes", Optional.ofNullable(attributes).orElse(List.of()));

        return map;
    }
}


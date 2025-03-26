package org.gycoding.heraldsofchaos.application.dto.out.characters;

import lombok.Builder;
import org.gycoding.heraldsofchaos.application.dto.out.StatODTO;
import org.gycoding.heraldsofchaos.application.dto.out.worlds.WorldODTO;

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
        StatODTO<Double> stats,
        List<AbilityODTO> abilities,
        String race,
        List<AttributeODTO> attributes
) {
    public Map<String, Object> toMap() {
        final var map = new java.util.HashMap<>(Map.of(
                "identifier", identifier,
                "name", name,
                "title", title,
                "description", description,
                "world", world != null ? world.identifier() : "null",
                "race", race,
                "image", image,
                "stats", stats,
                "abilities", abilities.isEmpty() ? abilities : List.of()
        ));

        map.put("attributes", Optional.ofNullable(attributes).orElse(List.of()));

        return map;
    }
}


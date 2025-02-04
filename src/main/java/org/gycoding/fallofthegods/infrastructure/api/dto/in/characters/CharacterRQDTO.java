package org.gycoding.fallofthegods.infrastructure.api.dto.in.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.StatMO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.StatRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds.WorldRQDTO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Builder
public record CharacterRQDTO(
        String identifier,
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        WorldRQDTO world,
        Boolean inGame,
        String image,
        StatRQDTO<Double> stats,
        List<AbilityRQDTO> abilities,
        TranslatedString race,
        List<AttributeRQDTO> attributes
) {
    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"title\": \"" + title + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"world\": \"" + world.identifier() + "\"," +
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


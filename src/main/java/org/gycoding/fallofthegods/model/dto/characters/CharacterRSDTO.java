package org.gycoding.fallofthegods.model.dto.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.model.dto.worlds.WorldRSDTO;
import org.gycoding.fallofthegods.model.entities.EntityStat;
import org.gycoding.fallofthegods.model.entities.worlds.EntityWorld;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Builder
public record CharacterRSDTO(
        String identifier,
        String name,
        String title,
        String description,
        WorldRSDTO world,
        Boolean inGame,
        String image,
        EntityStat<Double> stats,
        AbilityRSDTO ability,
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
                "\"world\": \"" + world.identifier() + "\"," +
                "\"race\": \"" + race + "\"," +
                "\"image\": \"" + image + "\"," +
                "\"stats\": " + stats + "," +
                "\"ability\": " + ability + "," +
                "\"attributes\": " + attributes +
                "}";
    }

    public Map<String, Object> toMap() {
        final var map = new java.util.HashMap<>(Map.of(
                "identifier", identifier,
                "name", name,
                "title", title,
                "description", description,
                "world", world.identifier(),
                "race", race,
                "image", image,
                "stats", stats,
                "ability", ability
        ));

        map.put("attributes", attributes);

        return map;
    }
}


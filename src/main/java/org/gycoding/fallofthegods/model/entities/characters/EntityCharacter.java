package org.gycoding.fallofthegods.model.entities.characters;

import java.util.List;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.gycoding.fallofthegods.model.entities.EntityStat;
import org.gycoding.fallofthegods.model.entities.worlds.EntityWorld;

import java.util.Map;

@Builder
@Document(collection = "Character")
public record EntityCharacter(
        @Id
        String mongoId,
        String identifier,
        String name,
        String title,
        String description,
        EntityWorld world,
        Boolean inGame,
        String image,
        EntityStat<Double> stats,
        EntityAbility ability,
        List<EntityStory> stories,
        String race,
        List<EntityAttribute> attributes
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
                "\"stories\": " + stories + "," +
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
                "ability", ability,
                "stories", stories
        ));

        map.put("attributes", attributes);

        return map;
    }
}


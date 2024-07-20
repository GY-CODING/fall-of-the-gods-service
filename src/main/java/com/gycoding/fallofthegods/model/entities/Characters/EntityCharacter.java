package com.gycoding.fallofthegods.model.entities.characters;

import com.gycoding.fallofthegods.model.entities.EntityStat;
import com.gycoding.fallofthegods.model.entities.worlds.EntityWorld;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
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
        List<EntityAbility> abilities,
        List<EntityStory> stories,
        String race
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
                "\"stories\": " + stories +
                "}";
    }

    public Map<String, Object> toMap() {
        return Map.of(
                "identifier", identifier,
                "name", name,
                "title", title,
                "description", description,
                "world", world.identifier(),
                "race", race,
                "image", image,
                "stats", stats,
                "abilities", abilities,
                "stories", stories
        );
    }
}


package com.gycoding.fallofthegods.model.entities.characters;

import java.util.List;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gycoding.fallofthegods.model.entities.EntityStat;
import com.gycoding.fallofthegods.model.entities.worlds.EntityWorld;

import java.util.Map;
import java.util.HashMap;

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
        List<EntityStory> stories
) {
    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"title\": \"" + title + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"world\": \"" + world.identifier() + "\"," +
                "\"image\": \"" + image + "\"," +
                "\"stats\": " + stats + "," +
                "\"ability\": " + ability + "," +
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
                "image", image,
                "stats", stats,
                "ability", ability,
                "stories", stories
        );
    }
}


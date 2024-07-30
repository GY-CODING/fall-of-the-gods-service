package org.gycoding.fallofthegods.model.entities.items;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.gycoding.fallofthegods.model.entities.EntityStat;

import java.util.Map;

@Builder
@Document(collection = "Item")
public record EntityItem(
    @Id
    String mongoId,
    String identifier,
    String name,
    String description,
    String image,
    Boolean inGame,
    EntityStat<EntityItemStat> stats
) {
    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"image\": \"" + image + "\"," +
                "\"stats\": " + stats +
                "}";
    }

    public Map<String, Object> toMap() {
        return Map.of(
                "identifier", identifier,
                "name", name,
                "description", description,
                "image", image,
                "stats", stats
        );
    }
}

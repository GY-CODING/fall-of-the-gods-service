package org.gycoding.fallofthegods.model.entities.worlds;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Builder
@Document(collection = "Place")
public record EntityPlace(
        @Id
        String mongoId,
        String identifier,
        String name,
        String description,
        String image,
        Boolean inGame
) {
    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"image\": \"" + image + "\"" +
                "}";
    }

    public Map<String, Object> toMap() {
        return Map.of(
                "identifier", identifier,
                "name", name,
                "description", description,
                "image", image
        );
    }
}

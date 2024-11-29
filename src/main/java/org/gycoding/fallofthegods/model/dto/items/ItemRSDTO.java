package org.gycoding.fallofthegods.model.dto.items;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.EntityStat;
import org.gycoding.fallofthegods.model.entities.TranslatedString;
import org.gycoding.fallofthegods.model.entities.items.EntityItemStat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.text.html.parser.Entity;
import java.util.Map;

@Builder
public record ItemRSDTO(
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

package org.gycoding.fallofthegods.model.dto.items;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.EntityStat;
import org.gycoding.fallofthegods.model.entities.TranslatedString;
import org.gycoding.fallofthegods.model.entities.items.EntityItemStat;
import org.gycoding.fallofthegods.model.entities.items.ItemType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Map;

@Builder
public record ItemRSDTO(
        String identifier,
        String name,
        String description,
        String image,
        Boolean inGame,
        ItemType type,
        List<ItemRSDTO> fragments,
        EntityStat<EntityItemStat> stats
) {
    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"," +
                "\"image\": \"" + image + "\"," +
                "\"stats\": " + stats + "," +
                "\"type\": \"" + type + "\"," +
                "\"fragments\": \"" + fragments +
                "}";
    }

    public Map<String, Object> toMap() {
        return Map.of(
                "identifier", identifier,
                "name", name,
                "description", description,
                "image", image,
                "stats", stats,
                "type", type,
                "fragments", fragments
        );
    }
}

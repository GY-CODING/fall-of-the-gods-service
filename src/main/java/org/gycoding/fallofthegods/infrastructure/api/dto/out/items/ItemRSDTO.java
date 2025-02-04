package org.gycoding.fallofthegods.infrastructure.api.dto.out.items;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.StatMO;
import org.gycoding.fallofthegods.domain.model.items.ItemStatMO;
import org.gycoding.fallofthegods.domain.model.items.ItemType;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.StatRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.StatRSDTO;

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
        StatRSDTO<ItemStatRSDTO> stats
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

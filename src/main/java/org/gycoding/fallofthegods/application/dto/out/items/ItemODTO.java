package org.gycoding.fallofthegods.application.dto.out.items;

import lombok.Builder;
import org.gycoding.fallofthegods.application.dto.out.StatODTO;
import org.gycoding.fallofthegods.domain.model.StatMO;
import org.gycoding.fallofthegods.domain.model.items.ItemStatMO;
import org.gycoding.fallofthegods.domain.model.items.ItemType;

import java.util.List;
import java.util.Map;

@Builder
public record ItemODTO(
        String identifier,
        String name,
        String description,
        String image,
        Boolean inGame,
        ItemType type,
        List<ItemODTO> fragments,
        StatODTO<ItemStatODTO> stats
) {
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

package org.gycoding.fallofthegods.infrastructure.api.dto.out.items;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.items.ItemType;

import java.util.List;

@Builder
public record ItemRSDTO(
        String identifier,
        String name,
        String description,
        String image,
        ItemType type,
        List<ItemRSDTO> fragments
) { }
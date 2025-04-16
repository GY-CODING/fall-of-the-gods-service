package org.gycoding.fallofthegods.infrastructure.api.dto.out.items;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.items.ItemType;

@Builder
public record ItemRSDTO(
        String identifier,
        String name,
        String description,
        String image,
        ItemType type
) { }
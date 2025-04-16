package org.gycoding.heraldsofchaos.infrastructure.api.dto.out.items;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.items.ItemType;

@Builder
public record ItemRSDTO(
        String identifier,
        String name,
        String description,
        String image,
        ItemType type
) { }
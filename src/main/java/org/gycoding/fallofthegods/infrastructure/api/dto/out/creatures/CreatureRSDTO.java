package org.gycoding.fallofthegods.infrastructure.api.dto.out.creatures;

import lombok.Builder;

import java.util.Map;

@Builder
public record CreatureRSDTO(
        String identifier,
        String name,
        String description,
        String image
) { }


package org.gycoding.fallofthegods.infrastructure.api.dto.out.worlds;

import lombok.Builder;

import java.util.Map;

@Builder
public record PlaceRSDTO(
        String identifier,
        String name,
        String description,
        String image
) { }
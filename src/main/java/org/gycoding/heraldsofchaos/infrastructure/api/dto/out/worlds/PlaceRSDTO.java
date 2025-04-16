package org.gycoding.heraldsofchaos.infrastructure.api.dto.out.worlds;

import lombok.Builder;

@Builder
public record PlaceRSDTO(
        String identifier,
        String name,
        String description,
        String image
) { }
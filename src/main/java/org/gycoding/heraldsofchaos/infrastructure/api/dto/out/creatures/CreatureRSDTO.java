package org.gycoding.heraldsofchaos.infrastructure.api.dto.out.creatures;

import lombok.Builder;

@Builder
public record CreatureRSDTO(
        String identifier,
        String name,
        String description,
        String image,
        String race
) { }


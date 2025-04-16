package org.gycoding.heraldsofchaos.infrastructure.api.dto.out.characters;

import lombok.Builder;

@Builder
public record CharacterRSDTO(
        String identifier,
        String name,
        String title,
        String description,
        String world,
        String image,
        String race
) { }


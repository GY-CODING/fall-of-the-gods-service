package org.gycoding.fallofthegods.infrastructure.api.dto.out.characters;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

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


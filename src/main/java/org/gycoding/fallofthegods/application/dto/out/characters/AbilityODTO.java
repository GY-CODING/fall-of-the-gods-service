package org.gycoding.fallofthegods.application.dto.out.characters;

import lombok.Builder;

@Builder
public record AbilityODTO(
        String name,
        String description,
        String identifier,
        Double damage,
        Double life,
        Double cooldown,
        Double timeToHit
) {}

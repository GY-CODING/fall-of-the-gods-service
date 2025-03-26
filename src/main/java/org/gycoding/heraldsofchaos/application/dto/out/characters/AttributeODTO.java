package org.gycoding.heraldsofchaos.application.dto.out.characters;

import lombok.Builder;

@Builder
public record AttributeODTO(
        String name,
        String description,
        String identifier
) {}

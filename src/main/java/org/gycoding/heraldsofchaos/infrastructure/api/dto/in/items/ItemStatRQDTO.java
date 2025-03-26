package org.gycoding.heraldsofchaos.infrastructure.api.dto.in.items;

import lombok.Builder;

@Builder
public record ItemStatRQDTO(
    String type,
    double value
) { }

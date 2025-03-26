package org.gycoding.heraldsofchaos.infrastructure.api.dto.out.items;

import lombok.Builder;

@Builder
public record ItemStatRSDTO(
    String type,
    double value
) { }

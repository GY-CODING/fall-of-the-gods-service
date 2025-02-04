package org.gycoding.fallofthegods.infrastructure.api.dto.out.items;

import lombok.Builder;

@Builder
public record ItemStatRSDTO(
    String type,
    double value
) { }

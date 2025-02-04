package org.gycoding.fallofthegods.infrastructure.api.dto.in.items;

import lombok.Builder;

@Builder
public record ItemStatRQDTO(
    String type,
    double value
) { }

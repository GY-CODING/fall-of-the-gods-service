package org.gycoding.fallofthegods.application.dto.in.items;

import lombok.Builder;

@Builder
public record ItemStatIDTO(
    String type,
    double value
) { }

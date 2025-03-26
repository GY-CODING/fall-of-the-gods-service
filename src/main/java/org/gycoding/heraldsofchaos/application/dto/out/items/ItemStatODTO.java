package org.gycoding.heraldsofchaos.application.dto.out.items;

import lombok.Builder;

@Builder
public record ItemStatODTO(
    String type,
    double value
) { }

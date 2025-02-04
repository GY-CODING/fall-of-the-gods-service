package org.gycoding.fallofthegods.domain.model.items;

import lombok.Builder;

@Builder
public record ItemStatMO(
    String type,
    double value
) { }

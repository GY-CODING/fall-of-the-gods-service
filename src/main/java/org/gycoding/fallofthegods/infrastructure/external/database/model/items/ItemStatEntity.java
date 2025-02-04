package org.gycoding.fallofthegods.infrastructure.external.database.model.items;

import lombok.Builder;

@Builder
public record ItemStatEntity(
        String type,
        double value
) {}

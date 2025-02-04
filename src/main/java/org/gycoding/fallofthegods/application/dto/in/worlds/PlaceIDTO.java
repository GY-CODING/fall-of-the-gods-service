package org.gycoding.fallofthegods.application.dto.in.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

@Builder
public record PlaceIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        Boolean inGame
) {}

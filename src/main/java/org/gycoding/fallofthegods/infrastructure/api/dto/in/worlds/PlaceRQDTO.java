package org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;

@Builder
public record PlaceRQDTO(
        TranslatedString name,
        TranslatedString description,
        String image,
        Boolean inGame
) { }
package org.gycoding.fallofthegods.application.dto.in.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;

@Builder
public record PlaceIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image
) {}

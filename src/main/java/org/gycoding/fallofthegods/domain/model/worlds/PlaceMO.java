package org.gycoding.fallofthegods.domain.model.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;

@Builder
public record PlaceMO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image
) {}

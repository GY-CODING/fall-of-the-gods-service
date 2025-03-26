package org.gycoding.heraldsofchaos.application.dto.in.worlds;

import lombok.Builder;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

@Builder
public record PlaceIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        Boolean inGame
) {}

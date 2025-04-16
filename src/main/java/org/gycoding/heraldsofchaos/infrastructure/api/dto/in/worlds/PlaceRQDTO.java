package org.gycoding.heraldsofchaos.infrastructure.api.dto.in.worlds;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;

@Builder
public record PlaceRQDTO(
        TranslatedString name,
        TranslatedString description,
        String image
) { }
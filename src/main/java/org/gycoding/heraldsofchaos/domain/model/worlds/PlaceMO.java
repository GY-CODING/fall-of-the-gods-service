package org.gycoding.heraldsofchaos.domain.model.worlds;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;

@Builder
public record PlaceMO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image
) {}

package org.gycoding.heraldsofchaos.domain.model.creatures;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;

@Builder
public record CreatureMO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        TranslatedString race
) {}


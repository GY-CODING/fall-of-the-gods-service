package org.gycoding.heraldsofchaos.application.dto.in.creatures;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;

@Builder
public record CreatureIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        TranslatedString race
) {}


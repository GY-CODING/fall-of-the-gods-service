package org.gycoding.heraldsofchaos.infrastructure.api.dto.in.creatures;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;

@Builder
public record CreatureRQDTO(
        TranslatedString name,
        TranslatedString description,
        String image,
        TranslatedString race
) { }
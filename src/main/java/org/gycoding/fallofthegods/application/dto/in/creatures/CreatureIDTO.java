package org.gycoding.fallofthegods.application.dto.in.creatures;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;

@Builder
public record CreatureIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image
) {}


package org.gycoding.fallofthegods.infrastructure.api.dto.in.creatures;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;

@Builder
public record CreatureRQDTO(
        TranslatedString name,
        TranslatedString description,
        Boolean inGame,
        String image
) { }
package org.gycoding.fallofthegods.domain.model.creatures;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;

@Builder
public record CreatureMO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        Boolean inGame,
        String image
) {}


package org.gycoding.fallofthegods.domain.model.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;

@Builder
public record CharacterMO(
        String identifier,
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        String world,
        String image,
        TranslatedString race
) { }


package org.gycoding.heraldsofchaos.domain.model.characters;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;

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


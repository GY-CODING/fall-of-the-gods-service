package org.gycoding.heraldsofchaos.application.dto.in.characters;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;

@Builder
public record CharacterIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        String world,
        String image,
        TranslatedString race
) {}


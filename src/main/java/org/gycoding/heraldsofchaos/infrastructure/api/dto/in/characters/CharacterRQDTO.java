package org.gycoding.heraldsofchaos.infrastructure.api.dto.in.characters;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;

@Builder
public record CharacterRQDTO(
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        String world,
        String image,
        TranslatedString race
) { }
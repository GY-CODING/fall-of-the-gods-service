package org.gycoding.fallofthegods.infrastructure.api.dto.in.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;

@Builder
public record CharacterRQDTO(
        String identifier,
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        String world,
        Boolean inGame,
        String image,
        TranslatedString race
) { }
package org.gycoding.fallofthegods.application.dto.in.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;

@Builder
public record CharacterIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        String world,
        Boolean inGame,
        String image,
        TranslatedString race
) {}


package org.gycoding.fallofthegods.domain.model.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.worlds.WorldMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

@Builder
public record CharacterMO(
        String identifier,
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        WorldMO world,
        Boolean inGame,
        String image,
        TranslatedString race
) { }


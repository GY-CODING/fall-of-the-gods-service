package org.gycoding.fallofthegods.application.dto.in.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.application.dto.in.StatIDTO;
import org.gycoding.fallofthegods.application.dto.in.worlds.WorldIDTO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

import java.util.List;

@Builder
public record CharacterIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        WorldIDTO world,
        Boolean inGame,
        String image,
        TranslatedString race
) {}


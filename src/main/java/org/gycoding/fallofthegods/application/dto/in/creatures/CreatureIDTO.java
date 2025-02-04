package org.gycoding.fallofthegods.application.dto.in.creatures;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

import java.util.Map;

@Builder
public record CreatureIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        Boolean inGame,
        String image
) {}


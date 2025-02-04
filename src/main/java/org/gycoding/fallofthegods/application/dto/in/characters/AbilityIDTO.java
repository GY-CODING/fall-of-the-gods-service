package org.gycoding.fallofthegods.application.dto.in.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

@Builder
public record AbilityIDTO(
        TranslatedString name,
        TranslatedString description,
        String identifier,
        Double damage,
        Double life,
        Double cooldown,
        Double timeToHit
) { }

package org.gycoding.heraldsofchaos.application.dto.in.characters;

import lombok.Builder;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

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

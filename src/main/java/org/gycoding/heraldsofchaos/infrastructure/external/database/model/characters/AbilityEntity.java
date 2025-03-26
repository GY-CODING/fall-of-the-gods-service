package org.gycoding.heraldsofchaos.infrastructure.external.database.model.characters;

import lombok.Builder;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

@Builder
public record AbilityEntity(
        TranslatedString name,
        TranslatedString description,
        String identifier,
        Double damage,
        Double life,
        Double cooldown,
        Double timeToHit
) {}

package org.gycoding.heraldsofchaos.domain.model.characters;

import lombok.Builder;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

@Builder
public record AbilityMO(
        TranslatedString name,
        TranslatedString description,
        String identifier,
        Double damage,
        Double life,
        Double cooldown,
        Double timeToHit
) {}

package org.gycoding.heraldsofchaos.domain.model.creatures;

import lombok.Builder;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

@Builder
public record CreatureMO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        Boolean inGame,
        String image
) {}


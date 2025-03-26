package org.gycoding.heraldsofchaos.application.dto.in.creatures;

import lombok.Builder;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

@Builder
public record CreatureIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        Boolean inGame,
        String image
) {}


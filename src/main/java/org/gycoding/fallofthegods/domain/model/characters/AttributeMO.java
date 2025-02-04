package org.gycoding.fallofthegods.domain.model.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

@Builder
public record AttributeMO(
        TranslatedString name,
        TranslatedString description,
        String identifier
) {}

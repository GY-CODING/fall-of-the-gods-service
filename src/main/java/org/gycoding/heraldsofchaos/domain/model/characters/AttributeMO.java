package org.gycoding.heraldsofchaos.domain.model.characters;

import lombok.Builder;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

@Builder
public record AttributeMO(
        TranslatedString name,
        TranslatedString description,
        String identifier
) {}

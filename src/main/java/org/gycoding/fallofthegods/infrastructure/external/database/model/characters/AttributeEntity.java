package org.gycoding.fallofthegods.infrastructure.external.database.model.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

@Builder
public record AttributeEntity(
        TranslatedString name,
        TranslatedString description,
        String identifier
) {}

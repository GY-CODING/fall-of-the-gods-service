package org.gycoding.fallofthegods.model.entities.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.TranslatedString;

@Builder
public record EntityAttribute(
        TranslatedString name,
        TranslatedString description,
        String identifier
) {}

package org.gycoding.fallofthegods.model.entities.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.TranslatedString;

@Builder
public record EntityAbility(
        TranslatedString name,
        TranslatedString description,
        String identifier,
        Double damage,
        Double life,
        Double cooldown,
        Double timeToHit
) {}

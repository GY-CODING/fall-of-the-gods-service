package org.gycoding.fallofthegods.domain.model.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.StatMO;
import org.gycoding.fallofthegods.domain.model.worlds.WorldMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

import java.util.List;

@Builder
public record CharacterMO(
        String identifier,
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        WorldMO world,
        Boolean inGame,
        String image,
        StatMO<Double> stats,
        List<AbilityMO> abilities,
        TranslatedString race,
        List<AttributeMO> attributes
) { }


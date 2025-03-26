package org.gycoding.heraldsofchaos.domain.model.characters;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.StatMO;
import org.gycoding.heraldsofchaos.domain.model.worlds.WorldMO;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

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


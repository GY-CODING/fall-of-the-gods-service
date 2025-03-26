package org.gycoding.heraldsofchaos.application.dto.in.characters;

import lombok.Builder;
import org.gycoding.heraldsofchaos.application.dto.in.StatIDTO;
import org.gycoding.heraldsofchaos.application.dto.in.worlds.WorldIDTO;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

import java.util.List;

@Builder
public record CharacterIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        WorldIDTO world,
        Boolean inGame,
        String image,
        StatIDTO<Double> stats,
        List<AbilityIDTO> abilities,
        TranslatedString race,
        List<AttributeIDTO> attributes
) {}


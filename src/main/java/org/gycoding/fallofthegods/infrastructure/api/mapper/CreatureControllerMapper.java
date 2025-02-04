package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.creatures.CreatureIDTO;
import org.gycoding.fallofthegods.application.dto.out.characters.CharacterODTO;
import org.gycoding.fallofthegods.application.dto.out.creatures.CreatureODTO;
import org.gycoding.fallofthegods.domain.model.characters.CharacterMO;
import org.gycoding.fallofthegods.domain.model.creatures.CreatureMO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.characters.CharacterRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.creatures.CreatureRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.characters.CharacterRSDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.creatures.CreatureRSDTO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;
import org.gycoding.fallofthegods.shared.util.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreatureControllerMapper {
    CreatureIDTO toIDTO(CreatureRQDTO creature);

    CreatureRSDTO toRSDTO(CreatureODTO creature);
}

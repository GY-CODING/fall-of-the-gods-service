package org.gycoding.fallofthegods.application.mapper;

import org.gycoding.fallofthegods.application.dto.in.creatures.CreatureIDTO;
import org.gycoding.fallofthegods.application.dto.out.creatures.CreatureODTO;
import org.gycoding.fallofthegods.domain.model.creatures.CreatureMO;
import org.gycoding.fallofthegods.shared.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { StringTranslator.class })
public interface CreatureServiceMapper {
    CreatureMO toMO(CreatureIDTO creature);

    @Mapping(target = "name", expression = "java(StringTranslator.translate(creature.name(), language))")
    @Mapping(target = "description", expression = "java(StringTranslator.translate(creature.description(), language))")
    CreatureODTO toODTO(CreatureMO creature, String language);
}

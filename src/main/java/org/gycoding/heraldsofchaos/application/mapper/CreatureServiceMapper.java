package org.gycoding.heraldsofchaos.application.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.creatures.CreatureIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.creatures.CreatureODTO;
import org.gycoding.heraldsofchaos.domain.model.creatures.CreatureMO;
import org.gycoding.heraldsofchaos.shared.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { StringTranslator.class })
public interface CreatureServiceMapper {
    CreatureMO toMO(CreatureIDTO creature);

    @Mapping(target = "name", expression = "java(StringTranslator.translate(creature.name(), language))")
    @Mapping(target = "description", expression = "java(StringTranslator.translate(creature.description(), language))")
    @Mapping(target = "race", expression = "java(StringTranslator.translate(creature.race(), language))")
    CreatureODTO toODTO(CreatureMO creature, String language);
}

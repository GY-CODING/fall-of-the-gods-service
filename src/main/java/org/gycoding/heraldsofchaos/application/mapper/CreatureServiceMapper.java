package org.gycoding.heraldsofchaos.application.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.creatures.CreatureIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.creatures.CreatureODTO;
import org.gycoding.heraldsofchaos.domain.model.creatures.CreatureMO;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;
import org.gycoding.heraldsofchaos.shared.util.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreatureServiceMapper {
    CreatureMO toMO(CreatureIDTO creature);

    @Mapping(target = "name", expression = "java(translate(creature.name(), language))")
    @Mapping(target = "description", expression = "java(translate(creature.description(), language))")
    CreatureODTO toODTO(CreatureMO creature, String language);

    default String translate(TranslatedString translatedString, String language) {
        return StringTranslator.translate(translatedString, language);
    }
}

package org.gycoding.fallofthegods.application.mapper;

import org.gycoding.fallofthegods.application.dto.in.characters.CharacterIDTO;
import org.gycoding.fallofthegods.application.dto.out.characters.CharacterODTO;
import org.gycoding.fallofthegods.domain.model.characters.CharacterMO;
import org.gycoding.fallofthegods.shared.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { StringTranslator.class })
public interface CharacterServiceMapper {
    CharacterMO toMO(CharacterIDTO character);

    @Mapping(target = "name", expression = "java(StringTranslator.translate(character.name(), language))")
    @Mapping(target = "title", expression = "java(StringTranslator.translate(character.title(), language))")
    @Mapping(target = "description", expression = "java(StringTranslator.translate(character.description(), language))")
    @Mapping(target = "race", expression = "java(StringTranslator.translate(character.race(), language))")
    @Mapping(target = "world", source = "character.world.identifier")
    CharacterODTO toODTO(CharacterMO character, String language);
}

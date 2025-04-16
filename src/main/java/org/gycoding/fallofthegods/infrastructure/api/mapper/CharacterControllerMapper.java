package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.characters.CharacterIDTO;
import org.gycoding.fallofthegods.application.dto.out.characters.CharacterODTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.characters.CharacterRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.characters.CharacterRSDTO;
import org.gycoding.fallofthegods.shared.IdentifierGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { IdentifierGenerator.class })
public interface CharacterControllerMapper {
    @Mapping(target = "identifier", expression = "java(IdentifierGenerator.generate(character.name().en()))")
    CharacterIDTO toIDTO(CharacterRQDTO character);

    @Mapping(target = "identifier", source = "identifier")
    CharacterIDTO toIDTO(CharacterRQDTO character, String identifier);

    CharacterRSDTO toRSDTO(CharacterODTO character);
}

package org.gycoding.heraldsofchaos.infrastructure.api.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.characters.CharacterIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.characters.CharacterODTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.in.characters.CharacterRQDTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.out.characters.CharacterRSDTO;
import org.gycoding.heraldsofchaos.shared.IdentifierGenerator;
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

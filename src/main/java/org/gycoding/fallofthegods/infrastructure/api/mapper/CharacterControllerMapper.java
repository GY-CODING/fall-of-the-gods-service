package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.characters.CharacterIDTO;
import org.gycoding.fallofthegods.application.dto.out.characters.CharacterODTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.characters.CharacterRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.characters.CharacterRSDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CharacterControllerMapper {
    CharacterIDTO toIDTO(CharacterRQDTO character);

    CharacterRSDTO toRSDTO(CharacterODTO character);
}

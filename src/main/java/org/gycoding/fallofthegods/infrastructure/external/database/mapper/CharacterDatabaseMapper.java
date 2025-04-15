package org.gycoding.fallofthegods.infrastructure.external.database.mapper;

import org.gycoding.fallofthegods.domain.model.characters.CharacterMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.characters.CharacterEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterDatabaseMapper {
    CharacterMO toMO(CharacterEntity character);

    CharacterEntity toEntity(CharacterMO character);
}

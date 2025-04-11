package org.gycoding.fallofthegods.infrastructure.external.database.mapper;

import org.gycoding.fallofthegods.domain.model.StatMO;
import org.gycoding.fallofthegods.domain.model.characters.CharacterMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.StatEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.model.characters.CharacterEntity;
import org.gycoding.fallofthegods.shared.util.MapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CharacterDatabaseMapper {
    CharacterMO toMO(CharacterEntity character);

    CharacterEntity toEntity(CharacterMO character);

    default StatMO<Double> toMO(StatEntity<Double> stats) {
        return MapperUtil.toMOForCharacters(stats);
    }

    default StatEntity<Double> toEntity(StatMO<Double> stats) {
        return MapperUtil.toEntityForCharacters(stats);
    }
}

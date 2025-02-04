package org.gycoding.fallofthegods.infrastructure.external.database.mapper;

import org.gycoding.fallofthegods.domain.model.creatures.CreatureMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.creatures.CreatureEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreatureDatabaseMapper {
    CreatureMO toMO(CreatureEntity creature);

    CreatureEntity toEntity(CreatureMO creature);
}

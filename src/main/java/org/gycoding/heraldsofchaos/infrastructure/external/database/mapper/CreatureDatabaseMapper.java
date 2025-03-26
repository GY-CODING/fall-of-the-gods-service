package org.gycoding.heraldsofchaos.infrastructure.external.database.mapper;

import org.gycoding.heraldsofchaos.domain.model.creatures.CreatureMO;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.creatures.CreatureEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreatureDatabaseMapper {
    CreatureMO toMO(CreatureEntity creature);

    CreatureEntity toEntity(CreatureMO creature);
}

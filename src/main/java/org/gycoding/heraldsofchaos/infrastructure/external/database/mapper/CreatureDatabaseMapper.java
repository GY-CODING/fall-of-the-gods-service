package org.gycoding.heraldsofchaos.infrastructure.external.database.mapper;

import org.gycoding.heraldsofchaos.domain.model.creatures.CreatureMO;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.creatures.CreatureEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CreatureDatabaseMapper {
    CreatureMO toMO(CreatureEntity creature);

    CreatureEntity toEntity(CreatureMO creature);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CreatureEntity toUpdatedEntity(@MappingTarget CreatureEntity persistedCreature, CreatureMO creature);
}

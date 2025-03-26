package org.gycoding.heraldsofchaos.infrastructure.external.database.mapper;

import org.gycoding.heraldsofchaos.domain.model.worlds.WorldMO;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.worlds.WorldEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorldDatabaseMapper {
    WorldMO toMO(WorldEntity world);

    WorldEntity toEntity(WorldMO world);
}

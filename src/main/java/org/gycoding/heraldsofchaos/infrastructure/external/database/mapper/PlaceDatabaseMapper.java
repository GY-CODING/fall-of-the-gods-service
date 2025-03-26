package org.gycoding.heraldsofchaos.infrastructure.external.database.mapper;

import org.gycoding.heraldsofchaos.domain.model.worlds.PlaceMO;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.worlds.PlaceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceDatabaseMapper {
    PlaceMO toMO(PlaceEntity place);

    PlaceEntity toEntity(PlaceMO place);
}

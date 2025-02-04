package org.gycoding.fallofthegods.infrastructure.external.database.mapper;

import org.gycoding.fallofthegods.domain.model.worlds.PlaceMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.worlds.PlaceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceDatabaseMapper {
    PlaceMO toMO(PlaceEntity place);

    PlaceEntity toEntity(PlaceMO place);
}

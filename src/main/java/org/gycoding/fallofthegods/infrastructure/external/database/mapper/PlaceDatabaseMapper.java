package org.gycoding.fallofthegods.infrastructure.external.database.mapper;

import org.gycoding.fallofthegods.domain.model.worlds.PlaceMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.worlds.PlaceEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PlaceDatabaseMapper {
    PlaceMO toMO(PlaceEntity place);

    PlaceEntity toEntity(PlaceMO place);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PlaceEntity toUpdatedEntity(@MappingTarget PlaceEntity persistedPlace, PlaceMO place);
}

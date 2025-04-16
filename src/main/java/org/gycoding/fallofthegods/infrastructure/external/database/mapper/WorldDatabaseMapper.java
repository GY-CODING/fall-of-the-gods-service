package org.gycoding.fallofthegods.infrastructure.external.database.mapper;

import org.gycoding.fallofthegods.domain.model.worlds.WorldMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.worlds.PlaceEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.model.worlds.WorldEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorldDatabaseMapper {
    WorldMO toMO(WorldEntity world);

    @Mapping(target = "places", source = "persistedPlaces")
    @Mapping(target = "identifier", source = "world.identifier")
    @Mapping(target = "name", source = "world.name")
    @Mapping(target = "description", source = "world.description")
    @Mapping(target = "image", source = "world.image")
    WorldEntity toEntity(WorldMO world, List<PlaceEntity> persistedPlaces);

    @Mapping(target = "places", source = "persistedPlaces")
    @Mapping(target = "identifier", source = "world.identifier")
    @Mapping(target = "name", source = "world.name")
    @Mapping(target = "description", source = "world.description")
    @Mapping(target = "image", source = "world.image")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    WorldEntity toUpdatedEntity(@MappingTarget WorldEntity persistedWorld, WorldMO world, List<PlaceEntity> persistedPlaces);
}

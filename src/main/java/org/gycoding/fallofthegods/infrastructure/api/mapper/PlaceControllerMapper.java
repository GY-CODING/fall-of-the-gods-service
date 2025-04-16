package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.worlds.PlaceIDTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.PlaceODTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds.PlaceRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.worlds.PlaceRSDTO;
import org.gycoding.fallofthegods.shared.IdentifierGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { IdentifierGenerator.class })
public interface PlaceControllerMapper {
    @Mapping(target = "identifier", expression = "java(IdentifierGenerator.generate(place.name().en()))")
    PlaceIDTO toIDTO(PlaceRQDTO place);

    PlaceRSDTO toRSDTO(PlaceODTO place);
}

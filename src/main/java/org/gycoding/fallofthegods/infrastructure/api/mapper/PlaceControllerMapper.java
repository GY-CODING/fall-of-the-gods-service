package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.worlds.PlaceIDTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.PlaceODTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds.PlaceRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.worlds.PlaceRSDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceControllerMapper {
    PlaceIDTO toIDTO(PlaceRQDTO place);

    PlaceRSDTO toRSDTO(PlaceODTO place);
}

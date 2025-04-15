package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.worlds.WorldIDTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.WorldODTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds.WorldRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.worlds.WorldRSDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorldControllerMapper {
    WorldIDTO toIDTO(WorldRQDTO place);

    WorldRSDTO toRSDTO(WorldODTO place);
}

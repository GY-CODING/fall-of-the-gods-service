package org.gycoding.heraldsofchaos.infrastructure.api.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.worlds.WorldIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.worlds.WorldODTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.in.worlds.WorldRQDTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.out.worlds.WorldRSDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorldControllerMapper {
    WorldIDTO toIDTO(WorldRQDTO place);

    WorldRSDTO toRSDTO(WorldODTO place);
}

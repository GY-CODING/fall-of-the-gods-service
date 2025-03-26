package org.gycoding.heraldsofchaos.infrastructure.api.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.worlds.PlaceIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.worlds.PlaceODTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.in.worlds.PlaceRQDTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.out.worlds.PlaceRSDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceControllerMapper {
    PlaceIDTO toIDTO(PlaceRQDTO place);

    PlaceRSDTO toRSDTO(PlaceODTO place);
}

package org.gycoding.heraldsofchaos.infrastructure.api.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.worlds.PlaceIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.worlds.PlaceODTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.in.worlds.PlaceRQDTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.out.worlds.PlaceRSDTO;
import org.gycoding.heraldsofchaos.shared.IdentifierGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { IdentifierGenerator.class })
public interface PlaceControllerMapper {
    @Mapping(target = "identifier", expression = "java(IdentifierGenerator.generate(place.name().en()))")
    PlaceIDTO toIDTO(PlaceRQDTO place);

    @Mapping(target = "identifier", source = "identifier")
    PlaceIDTO toIDTO(PlaceRQDTO place, String identifier);

    PlaceRSDTO toRSDTO(PlaceODTO place);
}

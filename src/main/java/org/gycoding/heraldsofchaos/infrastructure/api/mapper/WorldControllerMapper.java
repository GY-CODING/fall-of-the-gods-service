package org.gycoding.heraldsofchaos.infrastructure.api.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.worlds.WorldIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.worlds.WorldODTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.in.worlds.WorldRQDTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.out.worlds.WorldRSDTO;
import org.gycoding.heraldsofchaos.shared.IdentifierGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { IdentifierGenerator.class })
public interface WorldControllerMapper {
    @Mapping(target = "identifier", expression = "java(IdentifierGenerator.generate(world.name().en()))")
    WorldIDTO toIDTO(WorldRQDTO world);

    @Mapping(target = "identifier", source = "identifier")
    WorldIDTO toIDTO(WorldRQDTO world, String identifier);

    WorldRSDTO toRSDTO(WorldODTO world);
}

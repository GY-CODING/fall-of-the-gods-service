package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.worlds.WorldIDTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.WorldODTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds.WorldRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.worlds.WorldRSDTO;
import org.gycoding.fallofthegods.shared.IdentifierGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { IdentifierGenerator.class })
public interface WorldControllerMapper {
    @Mapping(target = "identifier", expression = "java(IdentifierGenerator.generate(world.name().en()))")
    WorldIDTO toIDTO(WorldRQDTO world);

    WorldRSDTO toRSDTO(WorldODTO world);
}

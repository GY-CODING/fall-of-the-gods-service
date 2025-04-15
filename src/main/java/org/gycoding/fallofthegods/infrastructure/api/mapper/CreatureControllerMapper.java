package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.creatures.CreatureIDTO;
import org.gycoding.fallofthegods.application.dto.out.creatures.CreatureODTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.creatures.CreatureRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.creatures.CreatureRSDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreatureControllerMapper {
    CreatureIDTO toIDTO(CreatureRQDTO creature);

    CreatureRSDTO toRSDTO(CreatureODTO creature);
}

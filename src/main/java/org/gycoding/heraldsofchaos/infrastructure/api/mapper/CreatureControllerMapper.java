package org.gycoding.heraldsofchaos.infrastructure.api.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.creatures.CreatureIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.creatures.CreatureODTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.in.creatures.CreatureRQDTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.out.creatures.CreatureRSDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreatureControllerMapper {
    CreatureIDTO toIDTO(CreatureRQDTO creature);

    CreatureRSDTO toRSDTO(CreatureODTO creature);
}

package org.gycoding.heraldsofchaos.infrastructure.api.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.creatures.CreatureIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.creatures.CreatureODTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.in.creatures.CreatureRQDTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.out.creatures.CreatureRSDTO;
import org.gycoding.heraldsofchaos.shared.IdentifierGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { IdentifierGenerator.class })
public interface CreatureControllerMapper {
    @Mapping(target = "identifier", expression = "java(IdentifierGenerator.generate(creature.name().en()))")
    CreatureIDTO toIDTO(CreatureRQDTO creature);

    @Mapping(target = "identifier", source = "identifier")
    CreatureIDTO toIDTO(CreatureRQDTO creature, String identifier);

    CreatureRSDTO toRSDTO(CreatureODTO creature);
}

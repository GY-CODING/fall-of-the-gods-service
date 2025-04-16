package org.gycoding.heraldsofchaos.infrastructure.api.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.items.ItemIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.items.ItemODTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.in.items.ItemRQDTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.out.items.ItemRSDTO;
import org.gycoding.heraldsofchaos.shared.IdentifierGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { IdentifierGenerator.class })
public interface ItemControllerMapper {
    @Mapping(target = "identifier", expression = "java(IdentifierGenerator.generate(item.name().en()))")
    ItemIDTO toIDTO(ItemRQDTO item);

    @Mapping(target = "identifier", source = "identifier")
    ItemIDTO toIDTO(ItemRQDTO item, String identifier);

    ItemRSDTO toRSDTO(ItemODTO item);
}

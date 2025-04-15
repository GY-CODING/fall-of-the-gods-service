package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.items.ItemIDTO;
import org.gycoding.fallofthegods.application.dto.out.items.ItemODTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.items.ItemRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.items.ItemRSDTO;
import org.gycoding.fallofthegods.shared.IdentifierGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { IdentifierGenerator.class })
public interface ItemControllerMapper {
    @Mapping(target = "identifier", expression = "java(IdentifierGenerator.generate(item.name().en()))")
    ItemIDTO toIDTO(ItemRQDTO item);

    ItemRSDTO toRSDTO(ItemODTO item);
}

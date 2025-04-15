package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.items.ItemIDTO;
import org.gycoding.fallofthegods.application.dto.out.items.ItemODTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.items.ItemRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.items.ItemRSDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemControllerMapper {
    ItemIDTO toIDTO(ItemRQDTO item);

    ItemRSDTO toRSDTO(ItemODTO item);
}

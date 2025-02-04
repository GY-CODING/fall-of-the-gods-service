package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.items.ItemIDTO;
import org.gycoding.fallofthegods.application.dto.out.creatures.CreatureODTO;
import org.gycoding.fallofthegods.application.dto.out.items.ItemODTO;
import org.gycoding.fallofthegods.domain.model.creatures.CreatureMO;
import org.gycoding.fallofthegods.domain.model.items.ItemMO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.creatures.CreatureRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.items.ItemRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.creatures.CreatureRSDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.items.ItemRSDTO;
import org.gycoding.fallofthegods.shared.mapper.ItemMapperUtils;
import org.gycoding.fallofthegods.shared.util.StringTranslator;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemControllerMapper {
    default ItemIDTO toIDTO(ItemRQDTO item) {
        if (item == null) {
            return null;
        }

        return ItemIDTO.builder()
                .identifier(item.identifier())
                .name(item.name())
                .description(item.description())
                .inGame(item.inGame())
                .image(item.image())
                .type(item.type())
                .stats(ItemMapperUtils.toStatIDTO(item.stats()))
                .fragments(ItemMapperUtils.toItemIDTOList(item.fragments()))
                .build();
    }

    default ItemRSDTO toRSDTO(ItemODTO item) {
        if (item == null) {
            return null;
        }

        return ItemRSDTO.builder()
                .identifier(item.identifier())
                .name(item.name())
                .description(item.description())
                .inGame(item.inGame())
                .image(item.image())
                .type(item.type())
                .stats(ItemMapperUtils.toStatRSDTO(item.stats()))
                .fragments(ItemMapperUtils.toItemRSDTOList(item.fragments()))
                .build();
    }
}

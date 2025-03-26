package org.gycoding.heraldsofchaos.infrastructure.api.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.items.ItemIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.items.ItemODTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.in.items.ItemRQDTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.out.items.ItemRSDTO;
import org.gycoding.heraldsofchaos.shared.mapper.ItemMapperUtils;
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

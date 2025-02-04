package org.gycoding.fallofthegods.application.mapper;

import org.gycoding.fallofthegods.application.dto.in.items.ItemIDTO;
import org.gycoding.fallofthegods.application.dto.out.items.ItemODTO;
import org.gycoding.fallofthegods.domain.model.items.ItemMO;
import org.gycoding.fallofthegods.shared.mapper.ItemMapperUtils;
import org.gycoding.fallofthegods.shared.util.StringTranslator;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemServiceMapper {
    default ItemMO toMO(ItemIDTO item) {
        if (item == null) {
            return null;
        }

        return ItemMO.builder()
                .identifier(item.identifier())
                .name(item.name())
                .description(item.description())
                .inGame(item.inGame())
                .image(item.image())
                .type(item.type())
                .stats(ItemMapperUtils.toStatMO(item.stats()))
                .fragments(ItemMapperUtils.toItemMOList(item.fragments()))
                .build();
    }

    default ItemODTO toODTO(ItemMO item, String language) {
        if (item == null) {
            return null;
        }

        return ItemODTO.builder()
                .identifier(item.identifier())
                .name(StringTranslator.translate(item.name(), language))
                .description(StringTranslator.translate(item.description(), language))
                .inGame(item.inGame())
                .image(item.image())
                .type(item.type())
                .stats(ItemMapperUtils.toStatODTO(item.stats()))
                .fragments(ItemMapperUtils.toItemODTOList(item.fragments(), language))
                .build();
    }
}

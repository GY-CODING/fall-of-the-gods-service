package org.gycoding.heraldsofchaos.application.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.items.ItemIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.items.ItemODTO;
import org.gycoding.heraldsofchaos.domain.model.items.ItemMO;
import org.gycoding.heraldsofchaos.shared.mapper.ItemMapperUtils;
import org.gycoding.heraldsofchaos.shared.util.StringTranslator;
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

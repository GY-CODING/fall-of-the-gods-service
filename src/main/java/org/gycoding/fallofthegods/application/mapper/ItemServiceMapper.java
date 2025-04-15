package org.gycoding.fallofthegods.application.mapper;

import org.gycoding.fallofthegods.application.dto.in.items.ItemIDTO;
import org.gycoding.fallofthegods.application.dto.out.items.ItemODTO;
import org.gycoding.fallofthegods.domain.model.items.ItemMO;
import org.gycoding.fallofthegods.shared.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", imports = { StringTranslator.class })
public interface ItemServiceMapper {
    ItemMO toMO(ItemIDTO item);

    @Mapping(target = "fragments", expression = "java(toItemODTOList(item.fragments(), language))")
    @Mapping(target = "name", expression = "java(StringTranslator.translate(item.name(), language))")
    @Mapping(target = "description", expression = "java(StringTranslator.translate(item.description(), language))")
    ItemODTO toODTO(ItemMO item, String language);

    default List<ItemODTO> toItemODTOList(List<ItemMO> items, String language) {
        return items.stream()
                .map(item -> toItemODTO(item, language))
                .toList();
    }

    @Mapping(target = "fragments", expression = "java(null)")
    @Mapping(target = "name", expression = "java(StringTranslator.translate(item.name(), language))")
    @Mapping(target = "description", expression = "java(StringTranslator.translate(item.description(), language))")
    ItemODTO toItemODTO(ItemMO item, String language);
}

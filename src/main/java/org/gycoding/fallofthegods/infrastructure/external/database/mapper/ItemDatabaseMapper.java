package org.gycoding.fallofthegods.infrastructure.external.database.mapper;

import org.gycoding.fallofthegods.domain.model.items.ItemMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.items.ItemEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ItemDatabaseMapper {
    ItemMO toMO(ItemEntity item);

    ItemEntity toEntity(ItemMO item);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ItemEntity toUpdatedEntity(@MappingTarget ItemEntity persistedItem, ItemMO item);
}

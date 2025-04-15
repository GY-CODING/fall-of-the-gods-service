package org.gycoding.fallofthegods.infrastructure.external.database.mapper;

import org.gycoding.fallofthegods.domain.model.items.ItemMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.items.ItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemDatabaseMapper {
    ItemMO toMO(ItemEntity item);

    ItemEntity toEntity(ItemMO item);
}

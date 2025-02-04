package org.gycoding.fallofthegods.infrastructure.external.database.mapper;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.StatMO;
import org.gycoding.fallofthegods.domain.model.items.ItemMO;
import org.gycoding.fallofthegods.domain.model.items.ItemStatMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.StatEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.model.items.ItemEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.model.items.ItemStatEntity;
import org.gycoding.fallofthegods.shared.util.MapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemDatabaseMapper {
    @Mapping(target = "stats", expression = "java(toMO(item.stats()))")
    ItemMO toMO(ItemEntity item);

    @Mapping(target = "stats", expression = "java(toEntity(item.stats()))")
    ItemEntity toEntity(ItemMO item);

    default StatMO<ItemStatMO> toMO(StatEntity<ItemStatEntity> stats) {
        return MapperUtil.toMOForItems(stats);
    }

    default StatEntity<ItemStatEntity> toEntity(StatMO<ItemStatMO> stats) {
        return MapperUtil.toEntityForItems(stats);
    }
}

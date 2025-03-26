package org.gycoding.heraldsofchaos.infrastructure.external.database.mapper;

import org.gycoding.heraldsofchaos.domain.model.StatMO;
import org.gycoding.heraldsofchaos.domain.model.items.ItemMO;
import org.gycoding.heraldsofchaos.domain.model.items.ItemStatMO;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.StatEntity;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.items.ItemEntity;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.items.ItemStatEntity;
import org.gycoding.heraldsofchaos.shared.util.MapperUtil;
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

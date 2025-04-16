package org.gycoding.fallofthegods.infrastructure.external.database.mapper;

import org.gycoding.fallofthegods.domain.model.achievements.AchievementMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.achievements.AchievementEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AchievementDatabaseMapper {
    AchievementMO toMO(AchievementEntity achievement);

    AchievementEntity toEntity(AchievementMO achievement);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AchievementEntity toUpdatedEntity(@MappingTarget AchievementEntity persistedAchievement, AchievementMO achievement);
}

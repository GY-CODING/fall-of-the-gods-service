package org.gycoding.fallofthegods.infrastructure.external.database.mapper;

import org.gycoding.fallofthegods.domain.model.achievements.AchievementMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.achievements.AchievementEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AchievementDatabaseMapper {
    AchievementMO toMO(AchievementEntity achievement);

    AchievementEntity toEntity(AchievementMO achievement);
}

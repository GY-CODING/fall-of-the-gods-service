package org.gycoding.heraldsofchaos.infrastructure.external.database.mapper;

import org.gycoding.heraldsofchaos.domain.model.achievements.AchievementMO;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.achievements.AchievementEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AchievementDatabaseMapper {
    AchievementMO toMO(AchievementEntity achievement);

    AchievementEntity toEntity(AchievementMO achievement);
}

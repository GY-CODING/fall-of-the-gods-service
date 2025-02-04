package org.gycoding.fallofthegods.infrastructure.external.database.mapper;

import org.gycoding.fallofthegods.application.dto.out.achievements.AchievementODTO;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;
import org.gycoding.fallofthegods.infrastructure.external.database.model.achievements.AchievementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AchievementDatabaseMapper {
    AchievementMO toMO(AchievementEntity achievement);

    AchievementEntity toEntity(AchievementMO achievement);
}

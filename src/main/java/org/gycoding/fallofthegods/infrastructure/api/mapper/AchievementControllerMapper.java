package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.achievements.AchievementIDTO;
import org.gycoding.fallofthegods.application.dto.out.achievements.AchievementODTO;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementMO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.achievements.AchievementRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.achievements.AchievementRSDTO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;
import org.gycoding.fallofthegods.shared.util.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AchievementControllerMapper {
    AchievementIDTO toIDTO(AchievementRQDTO achievement);

    AchievementRSDTO toRSDTO(AchievementODTO achievement);
}

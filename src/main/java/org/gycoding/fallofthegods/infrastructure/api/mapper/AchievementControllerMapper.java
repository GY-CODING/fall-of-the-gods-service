package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.achievements.AchievementIDTO;
import org.gycoding.fallofthegods.application.dto.out.achievements.AchievementODTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.achievements.AchievementRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.achievements.AchievementRSDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AchievementControllerMapper {
    AchievementIDTO toIDTO(AchievementRQDTO achievement);

    AchievementRSDTO toRSDTO(AchievementODTO achievement);
}

package org.gycoding.heraldsofchaos.infrastructure.api.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.achievements.AchievementIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.achievements.AchievementODTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.in.achievements.AchievementRQDTO;
import org.gycoding.heraldsofchaos.infrastructure.api.dto.out.achievements.AchievementRSDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AchievementControllerMapper {
    AchievementIDTO toIDTO(AchievementRQDTO achievement);

    AchievementRSDTO toRSDTO(AchievementODTO achievement);
}

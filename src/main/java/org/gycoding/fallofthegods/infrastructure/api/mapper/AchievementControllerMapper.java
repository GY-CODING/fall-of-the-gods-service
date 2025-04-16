package org.gycoding.fallofthegods.infrastructure.api.mapper;

import org.gycoding.fallofthegods.application.dto.in.achievements.AchievementIDTO;
import org.gycoding.fallofthegods.application.dto.out.achievements.AchievementODTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.achievements.AchievementRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.achievements.AchievementRSDTO;
import org.gycoding.fallofthegods.shared.IdentifierGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { IdentifierGenerator.class })
public interface AchievementControllerMapper {
    @Mapping(target = "identifier", expression = "java(IdentifierGenerator.generate(achievement.name().en()))")
    AchievementIDTO toIDTO(AchievementRQDTO achievement);

    @Mapping(target = "identifier", source = "identifier")
    AchievementIDTO toIDTO(AchievementRQDTO achievement, String identifier);

    AchievementRSDTO toRSDTO(AchievementODTO achievement);
}

package org.gycoding.fallofthegods.application.mapper;

import org.gycoding.fallofthegods.application.dto.in.achievements.AchievementIDTO;
import org.gycoding.fallofthegods.application.dto.out.achievements.AchievementODTO;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementMO;
import org.gycoding.fallofthegods.shared.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { StringTranslator.class })
public interface AchievementServiceMapper {
    AchievementMO toMO(AchievementIDTO achievement);

    @Mapping(target = "name", expression = "java(StringTranslator.translate(achievement.name(), language))")
    @Mapping(target = "description", expression = "java(StringTranslator.translate(achievement.description(), language))")
    AchievementODTO toODTO(AchievementMO achievement, String language);
}

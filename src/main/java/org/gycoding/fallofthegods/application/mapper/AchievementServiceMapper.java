package org.gycoding.fallofthegods.application.mapper;

import org.gycoding.fallofthegods.application.dto.in.achievements.AchievementIDTO;
import org.gycoding.fallofthegods.application.dto.out.achievements.AchievementODTO;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementMO;
import org.gycoding.fallofthegods.shared.util.StringTranslator;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AchievementServiceMapper {
    AchievementMO toMO(AchievementIDTO achievement);

    @Mapping(target = "name", expression = "java(translate(achievement.name(), language))")
    @Mapping(target = "description", expression = "java(translate(achievement.description(), language))")
    AchievementODTO toODTO(AchievementMO achievement, String language);

    default String translate(TranslatedString translatedString, String language) {
        return StringTranslator.translate(translatedString, language);
    }
}

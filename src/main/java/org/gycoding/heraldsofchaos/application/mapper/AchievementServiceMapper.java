package org.gycoding.heraldsofchaos.application.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.achievements.AchievementIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.achievements.AchievementODTO;
import org.gycoding.heraldsofchaos.domain.model.achievements.AchievementMO;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;
import org.gycoding.heraldsofchaos.shared.util.StringTranslator;
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

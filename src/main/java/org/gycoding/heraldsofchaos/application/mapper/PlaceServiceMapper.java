package org.gycoding.heraldsofchaos.application.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.worlds.PlaceIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.worlds.PlaceODTO;
import org.gycoding.heraldsofchaos.domain.model.worlds.PlaceMO;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;
import org.gycoding.heraldsofchaos.shared.util.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlaceServiceMapper {
    PlaceMO toMO(PlaceIDTO place);

    @Mapping(target = "name", expression = "java(translate(place.name(), language))")
    @Mapping(target = "description", expression = "java(translate(place.description(), language))")
    PlaceODTO toODTO(PlaceMO place, String language);

    default String translate(TranslatedString translatedString, String language) {
        return StringTranslator.translate(translatedString, language);
    }
}

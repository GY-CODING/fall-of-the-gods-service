package org.gycoding.fallofthegods.application.mapper;

import org.gycoding.fallofthegods.application.dto.in.worlds.PlaceIDTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.PlaceODTO;
import org.gycoding.fallofthegods.domain.model.worlds.PlaceMO;
import org.gycoding.fallofthegods.shared.util.StringTranslator;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;
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

package org.gycoding.fallofthegods.application.mapper;

import org.gycoding.fallofthegods.application.dto.in.worlds.PlaceIDTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.PlaceODTO;
import org.gycoding.fallofthegods.domain.model.worlds.PlaceMO;
import org.gycoding.fallofthegods.shared.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { StringTranslator.class })
public interface PlaceServiceMapper {
    PlaceMO toMO(PlaceIDTO place);

    @Mapping(target = "name", expression = "java(StringTranslator.translate(place.name(), language))")
    @Mapping(target = "description", expression = "java(StringTranslator.translate(place.description(), language))")
    PlaceODTO toODTO(PlaceMO place, String language);
}

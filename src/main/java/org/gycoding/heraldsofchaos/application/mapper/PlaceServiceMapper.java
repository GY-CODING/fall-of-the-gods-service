package org.gycoding.heraldsofchaos.application.mapper;

import org.gycoding.heraldsofchaos.application.dto.in.worlds.PlaceIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.worlds.PlaceODTO;
import org.gycoding.heraldsofchaos.domain.model.worlds.PlaceMO;
import org.gycoding.heraldsofchaos.shared.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { StringTranslator.class })
public interface PlaceServiceMapper {
    PlaceMO toMO(PlaceIDTO place);

    @Mapping(target = "name", expression = "java(StringTranslator.translate(place.name(), language))")
    @Mapping(target = "description", expression = "java(StringTranslator.translate(place.description(), language))")
    PlaceODTO toODTO(PlaceMO place, String language);
}

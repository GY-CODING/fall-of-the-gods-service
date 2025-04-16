package org.gycoding.fallofthegods.application.mapper;

import org.gycoding.fallofthegods.application.dto.in.worlds.WorldIDTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.PlaceODTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.WorldODTO;
import org.gycoding.fallofthegods.domain.model.worlds.PlaceMO;
import org.gycoding.fallofthegods.domain.model.worlds.WorldMO;
import org.gycoding.fallofthegods.shared.StringTranslator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = { StringTranslator.class })
public interface WorldServiceMapper {
    @Mapping(target = "places", ignore = true)
    WorldMO toMO(WorldIDTO world);

    @Mapping(target = "name", expression = "java(StringTranslator.translate(world.name(), language))")
    @Mapping(target = "description", expression = "java(StringTranslator.translate(world.description(), language))")
    @Mapping(target = "places", expression = "java(toPlaceODTOList(world.places(), language))")
    WorldODTO toODTO(WorldMO world, String language);

    default List<PlaceODTO> toPlaceODTOList(List<PlaceMO> places, String language) {
        return places.stream()
                .map(place -> toPlaceODTO(place, language))
                .collect(Collectors.toList());
    }

    @Mapping(target = "name", expression = "java(StringTranslator.translate(place.name(), language))")
    @Mapping(target = "description", expression = "java(StringTranslator.translate(place.description(), language))")
    PlaceODTO toPlaceODTO(PlaceMO place, String language);
}

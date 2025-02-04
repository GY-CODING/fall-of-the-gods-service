package org.gycoding.fallofthegods.shared.mapper;

import org.gycoding.fallofthegods.application.dto.in.worlds.PlaceIDTO;
import org.gycoding.fallofthegods.application.dto.in.worlds.WorldIDTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.PlaceODTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.WorldODTO;
import org.gycoding.fallofthegods.domain.model.worlds.PlaceMO;
import org.gycoding.fallofthegods.domain.model.worlds.WorldMO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds.PlaceRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds.WorldRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.worlds.PlaceRSDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.worlds.WorldRSDTO;
import org.gycoding.fallofthegods.shared.util.StringTranslator;

import java.util.List;
import java.util.stream.Collectors;

public class WorldMapperUtils {
    public static WorldODTO toWorldODTO(WorldMO world, String language) {
        if (world == null) {
            return null;
        }

        return WorldODTO.builder()
                .identifier(world.identifier())
                .name(StringTranslator.translate(world.name(), language))
                .description(StringTranslator.translate(world.description(), language))
                .image(world.image())
                .detailedIcon(world.detailedIcon())
                .places(toPlaceODTOList(world.places(), language))
                .build();
    }

    public static List<PlaceODTO> toPlaceODTOList(List<PlaceMO> places, String language) {
        return places.stream()
                .map(place -> toPlaceODTO(place, language))
                .collect(Collectors.toList());
    }

    public static PlaceODTO toPlaceODTO(PlaceMO place, String language) {
        if (place == null) {
            return null;
        }

        return PlaceODTO.builder()
                .identifier(place.identifier())
                .name(StringTranslator.translate(place.name(), language))
                .description(StringTranslator.translate(place.description(), language))
                .image(place.image())
                .inGame(place.inGame())
                .build();
    }

    public static WorldMO toWorldMO(WorldIDTO world) {
        if (world == null) {
            return null;
        }

        return WorldMO.builder()
                .identifier(world.identifier())
                .name(world.name())
                .description(world.description())
                .image(world.image())
                .detailedIcon(world.detailedIcon())
                .places(toPlaceMOList(world.places()))
                .build();
    }

    public static List<PlaceMO> toPlaceMOList(List<PlaceIDTO> places) {
        return places.stream()
                .map(place -> toPlaceMO(place))
                .collect(Collectors.toList());
    }

    public static PlaceMO toPlaceMO(PlaceIDTO place) {
        if (place == null) {
            return null;
        }

        return PlaceMO.builder()
                .identifier(place.identifier())
                .name(place.name())
                .description(place.description())
                .image(place.image())
                .inGame(place.inGame())
                .build();
    }

    public static WorldIDTO toWorldIDTO(WorldRQDTO world) {
        if (world == null) {
            return null;
        }

        return WorldIDTO.builder()
                .identifier(world.identifier())
                .name(world.name())
                .description(world.description())
                .image(world.image())
                .detailedIcon(world.detailedIcon())
                .places(toPlaceIDTOList(world.places()))
                .build();
    }

    public static List<PlaceIDTO> toPlaceIDTOList(List<PlaceRQDTO> places) {
        return places.stream()
                .map(WorldMapperUtils::toPlaceIDTO)
                .collect(Collectors.toList());
    }

    public static PlaceIDTO toPlaceIDTO(PlaceRQDTO place) {
        if (place == null) {
            return null;
        }

        return PlaceIDTO.builder()
                .identifier(place.identifier())
                .name(place.name())
                .description(place.description())
                .image(place.image())
                .inGame(place.inGame())
                .build();
    }

    public static WorldRSDTO toWorldRSDTO(WorldODTO world) {
        if (world == null) {
            return null;
        }

        return WorldRSDTO.builder()
                .identifier(world.identifier())
                .name(world.name())
                .description(world.description())
                .image(world.image())
                .detailedIcon(world.detailedIcon())
                .places(toPlaceRSDTOList(world.places()))
                .build();
    }

    public static List<PlaceRSDTO> toPlaceRSDTOList(List<PlaceODTO> places) {
        return places.stream()
                .map(WorldMapperUtils::toPlaceRSDTO)
                .collect(Collectors.toList());
    }

    public static PlaceRSDTO toPlaceRSDTO(PlaceODTO place) {
        if (place == null) {
            return null;
        }

        return PlaceRSDTO.builder()
                .identifier(place.identifier())
                .name(place.name())
                .description(place.description())
                .image(place.image())
                .inGame(place.inGame())
                .build();
    }
}

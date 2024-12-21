package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.fallofthegods.model.database.repository.WorldRepository;
import org.gycoding.fallofthegods.model.dto.worlds.PlaceRSDTO;
import org.gycoding.fallofthegods.model.dto.worlds.WorldRSDTO;
import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.model.entities.utiles.PagingConverter;
import org.gycoding.fallofthegods.model.entities.worlds.EntityPlace;
import org.gycoding.fallofthegods.model.entities.worlds.EntityWorld;
import org.gycoding.exceptions.model.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorldService {
    @Autowired
    private final WorldRepository worldRepository = null;

    public WorldRSDTO getWorld(String id, String language) throws APIException {
        final var worldEntity = worldRepository.findByIdentifier(id).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return WorldRSDTO.builder()
                .identifier(worldEntity.identifier())
                .name(worldEntity.name().get(language))
                .description(worldEntity.description().get(language))
                .image(worldEntity.image())
                .detailedIcon(worldEntity.detailedIcon())
                .places(!worldEntity.places().isEmpty() ? worldEntity.places().stream().map(place -> PlaceRSDTO.builder()
                        .identifier(place.identifier())
                        .name(place.name().get(language))
                        .description(place.description().get(language))
                        .image(place.image())
                        .inGame(place.inGame())
                        .build()
                ).toList() : List.of())
                .build();
    }

    public List<WorldRSDTO> listWorlds(String language) throws APIException {
        try {
            final var worldEntities = worldRepository.findAll();

            return worldEntities.stream().map(worldEntity -> WorldRSDTO.builder()
                    .identifier(worldEntity.identifier())
                    .name(worldEntity.name().get(language))
                    .description(worldEntity.description().get(language))
                    .image(worldEntity.image())
                    .detailedIcon(worldEntity.detailedIcon())
                    .places(!worldEntity.places().isEmpty() ? worldEntity.places().stream().map(place -> PlaceRSDTO.builder()
                            .identifier(place.identifier())
                            .name(place.name().get(language))
                            .description(place.description().get(language))
                            .image(place.image())
                            .inGame(place.inGame())
                            .build()
                    ).toList() : List.of())
                    .build()
            ).toList();
        } catch(NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }

    public Page<Map<String, Object>> pageWorlds(Pageable pageable, String language) throws APIException {
        try {
            final var worldEntities = worldRepository.findAll(pageable);

            return worldEntities.map(worldEntity -> WorldRSDTO.builder()
                    .identifier(worldEntity.identifier())
                    .name(worldEntity.name().get(language))
                    .description(worldEntity.description().get(language))
                    .image(worldEntity.image())
                    .detailedIcon(worldEntity.detailedIcon())
                    .places(!worldEntity.places().isEmpty() ? worldEntity.places().stream().map(place -> PlaceRSDTO.builder()
                            .identifier(place.identifier())
                            .name(place.name().get(language))
                            .description(place.description().get(language))
                            .image(place.image())
                            .inGame(place.inGame())
                            .build()
                    ).toList() : List.of())
                    .build().toMap()
            );
        } catch(NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }

    public PlaceRSDTO getWorldPlace(String idWorld, String idPlace, String language) throws APIException {
        final var worldEntity = worldRepository.findByIdentifier(idWorld).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        final var worldDTO = WorldRSDTO.builder()
                .identifier(worldEntity.identifier())
                .name(worldEntity.name().get(language))
                .description(worldEntity.description().get(language))
                .image(worldEntity.image())
                .detailedIcon(worldEntity.detailedIcon())
                .places(!worldEntity.places().isEmpty() ? worldEntity.places().stream().map(place -> PlaceRSDTO.builder()
                        .identifier(place.identifier())
                        .name(place.name().get(language))
                        .description(place.description().get(language))
                        .image(place.image())
                        .inGame(place.inGame())
                        .build()
                ).toList() : List.of())
                .build();

        return worldDTO.places().stream()
                .filter(place -> place.identifier().equals(idPlace))
                .findFirst()
                .orElseThrow(() ->
                    new APIException(
                            FOTGAPIError.RESOURCE_NOT_FOUND.code,
                            FOTGAPIError.RESOURCE_NOT_FOUND.message,
                            FOTGAPIError.RESOURCE_NOT_FOUND.status
                    )
                );
    }

    public List<PlaceRSDTO> listWorldPlaces(String id, String language) throws APIException {
        final var worldEntity = worldRepository.findByIdentifier(id).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return worldEntity.places().stream().map(place -> PlaceRSDTO.builder()
                .identifier(place.identifier())
                .name(place.name().get(language))
                .description(place.description().get(language))
                .image(place.image())
                .inGame(place.inGame())
                .build()
        ).toList();
    }

    public Page<Map<String, Object>> pageWorldPlaces(String id, Pageable pageable, String language) throws APIException {
        final var worldEntity = worldRepository.findByIdentifier(id).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        final var placesDTO = worldEntity.places().stream()
                .map(place -> PlaceRSDTO.builder()
                    .identifier(place.identifier())
                    .name(place.name().get(language))
                    .description(place.description().get(language))
                    .image(place.image())
                    .inGame(place.inGame())
                    .build().toMap()
                ).toList();

        return PagingConverter.listToPage(placesDTO, pageable);
    }
}

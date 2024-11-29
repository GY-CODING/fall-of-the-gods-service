package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.fallofthegods.model.database.repository.PlaceRepository;
import org.gycoding.fallofthegods.model.dto.worlds.PlaceRSDTO;
import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.model.entities.worlds.EntityPlace;
import org.gycoding.exceptions.model.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlaceService {
    @Autowired
    private final PlaceRepository placeRepository = null;

    public PlaceRSDTO getPlace(String id, String language) throws APIException {
        final var placeEntity = placeRepository.findByIdentifier(id).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.PLACE_NOT_FOUND.getCode(),
                        FOTGAPIError.PLACE_NOT_FOUND.getMessage(),
                        FOTGAPIError.PLACE_NOT_FOUND.getStatus()
                )
        );

        return PlaceRSDTO.builder()
                .identifier(placeEntity.identifier())
                .name(placeEntity.name().get(language))
                .description(placeEntity.description().get(language))
                .image(placeEntity.image())
                .inGame(placeEntity.inGame())
                .build();
    }

    public List<PlaceRSDTO> listPlaces(String language) throws APIException {
        try {
            final var placeEntities = placeRepository.findAll();

            return placeEntities.stream().map(placeEntity -> PlaceRSDTO.builder()
                    .identifier(placeEntity.identifier())
                    .name(placeEntity.name().get(language))
                    .description(placeEntity.description().get(language))
                    .image(placeEntity.image())
                    .inGame(placeEntity.inGame())
                    .build()
            ).toList();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_PLACE_NOT_FOUND.getCode(),
                    FOTGAPIError.LIST_PLACE_NOT_FOUND.getMessage(),
                    FOTGAPIError.LIST_PLACE_NOT_FOUND.getStatus()
            );
        }
    }

    public Page<Map<String, Object>> pagePlaces(Pageable pageable, String language) throws APIException {
        try {
            final var placeEntities = placeRepository.findAll(pageable);

            return placeEntities.map(placeEntity -> PlaceRSDTO.builder()
                    .identifier(placeEntity.identifier())
                    .name(placeEntity.name().get(language))
                    .description(placeEntity.description().get(language))
                    .image(placeEntity.image())
                    .inGame(placeEntity.inGame())
                    .build().toMap()
            );
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_PLACE_NOT_FOUND.getCode(),
                    FOTGAPIError.LIST_PLACE_NOT_FOUND.getMessage(),
                    FOTGAPIError.LIST_PLACE_NOT_FOUND.getStatus()
            );
        }
    }
}

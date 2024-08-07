package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.fallofthegods.model.database.repository.PlaceRepository;
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

    public EntityPlace getPlace(String id) throws APIException {
        return placeRepository.findByIdentifier(id).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.PLACE_NOT_FOUND.getCode(),
                        FOTGAPIError.PLACE_NOT_FOUND.getMessage(),
                        FOTGAPIError.PLACE_NOT_FOUND.getStatus()
                )
        );
    }

    public List<EntityPlace> listPlaces() throws APIException {
        try {
            return placeRepository.findAll();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_PLACE_NOT_FOUND.getCode(),
                    FOTGAPIError.LIST_PLACE_NOT_FOUND.getMessage(),
                    FOTGAPIError.LIST_PLACE_NOT_FOUND.getStatus()
            );
        }
    }

    public Page<Map<String, Object>> pagePlaces(Pageable pageable) throws APIException {
        try {
            return placeRepository.findAll(pageable)
                    .map(EntityPlace::toMap);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_PLACE_NOT_FOUND.getCode(),
                    FOTGAPIError.LIST_PLACE_NOT_FOUND.getMessage(),
                    FOTGAPIError.LIST_PLACE_NOT_FOUND.getStatus()
            );
        }
    }
}

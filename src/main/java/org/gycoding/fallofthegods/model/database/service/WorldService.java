package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.fallofthegods.model.database.repository.WorldRepository;
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

    public EntityWorld getWorld(String id) throws APIException {
        return worldRepository.findByIdentifier(id).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.WORLD_NOT_FOUND.getCode(),
                        FOTGAPIError.WORLD_NOT_FOUND.getMessage(),
                        FOTGAPIError.WORLD_NOT_FOUND.getStatus()
                )
        );
    }

    public List<EntityWorld> listWorlds() throws APIException {
        try {
            return worldRepository.findAll();
        } catch(NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_WORLD_NOT_FOUND.getCode(),
                    FOTGAPIError.LIST_WORLD_NOT_FOUND.getMessage(),
                    FOTGAPIError.LIST_WORLD_NOT_FOUND.getStatus()
            );
        }
    }

    public Page<Map<String, Object>> pageWorlds(Pageable pageable) throws APIException {
        try {
            return worldRepository.findAll(pageable)
                    .map(EntityWorld::toMap);
        } catch(NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_WORLD_NOT_FOUND.getCode(),
                    FOTGAPIError.LIST_WORLD_NOT_FOUND.getMessage(),
                    FOTGAPIError.LIST_WORLD_NOT_FOUND.getStatus()
            );
        }
    }

    public EntityPlace getWorldPlace(String idWorld, String idPlace) throws APIException {
        return worldRepository.findByIdentifier(idWorld).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.WORLD_NOT_FOUND.getCode(),
                        FOTGAPIError.WORLD_NOT_FOUND.getMessage(),
                        FOTGAPIError.WORLD_NOT_FOUND.getStatus()
                )
        ).getPlace(idPlace);
    }

    public List<EntityPlace> listWorldPlaces(String id) throws APIException {
        return worldRepository.findByIdentifier(id).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.LIST_PLACE_NOT_FOUND.getCode(),
                        FOTGAPIError.LIST_PLACE_NOT_FOUND.getMessage(),
                        FOTGAPIError.LIST_PLACE_NOT_FOUND.getStatus()
                )
        ).listPlaces();
    }

    public Page<Map<String, Object>> pageWorldPlaces(String id, Pageable pageable) throws APIException {
        return PagingConverter.listToPage(worldRepository.findByIdentifier(id).orElseThrow((() ->
            new APIException(
                FOTGAPIError.LIST_PLACE_NOT_FOUND.getCode(),
                FOTGAPIError.LIST_PLACE_NOT_FOUND.getMessage(),
                FOTGAPIError.LIST_PLACE_NOT_FOUND.getStatus()
            )
        )).listPlaces(), pageable)
            .map(EntityPlace::toMap);
    }
}

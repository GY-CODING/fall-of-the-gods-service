package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.WorldRepository;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIException;
import com.gycoding.fallofthegods.model.entities.utiles.PagingConverter;
import com.gycoding.fallofthegods.model.entities.worlds.EntityPlace;
import com.gycoding.fallofthegods.model.entities.worlds.EntityWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service for the World entity.
 * @see EntityWorld
 * @see WorldRepository
 * @see Service
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Service
public class WorldService {
    @Autowired
    private final WorldRepository worldRepository = null;

    /**
     * Finds a World by its identifier.
     * @param id
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityWorld
     * @see WorldRepository
     * @throws FOTGAPIException
     */
    public EntityWorld getWorld(String id) throws FOTGAPIException {
        return worldRepository.findByIdentifier(id).orElseThrow(() ->
                new FOTGAPIException(ServerStatus.WORLD_NOT_FOUND)
        );
    }

    /**
     * Lists all the worlds.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityWorld
     * @see WorldRepository
     * @throws FOTGAPIException
     */
    public List<EntityWorld> listWorlds() throws FOTGAPIException {
        try {
            return worldRepository.findAll();
        } catch(NullPointerException e) {
            throw new FOTGAPIException(ServerStatus.LIST_WORLD_NOT_FOUND);
        }
    }

    /**
     * Lists all the worlds with pagination.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Pageable
     * @see Page
     * @see Map
     * @see EntityWorld
     * @see WorldRepository
     * @throws FOTGAPIException
     */
    public Page<Map<String, Object>> pageWorlds(Pageable pageable) throws FOTGAPIException {
        try {
            return worldRepository.findAll(pageable)
                    .map(EntityWorld::toMap);
        } catch(NullPointerException e) {
            throw new FOTGAPIException(ServerStatus.LIST_WORLD_NOT_FOUND);
        }
    }

    /**
     * Finds a specific Place in a specific World, both identified by their own identifier.
     * @param idWorld World's identifier.
     * @param idPlace idPlace Place's identifier.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityPlace
     * @see WorldRepository
     * @throws FOTGAPIException
     */
    public EntityPlace getWorldPlace(String idWorld, String idPlace) throws FOTGAPIException {
        return worldRepository.findByIdentifier(idWorld).orElseThrow(() ->
                new FOTGAPIException(ServerStatus.WORLD_NOT_FOUND)
        ).getPlace(idPlace);
    }

    /**
     * Lists all the places in a specific world (specified by its identifier).
     * @param id World's identifier.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityPlace
     * @see WorldRepository
     * @throws FOTGAPIException
     */
    public List<EntityPlace> listWorldPlaces(String id) throws FOTGAPIException {
        return worldRepository.findByIdentifier(id).orElseThrow(() ->
                new FOTGAPIException(ServerStatus.LIST_WORLD_NOT_FOUND)
        ).listPlaces();
    }

    /**
     * Lists all the places in a specific world (specified by its identifier) with pagination.
     * @param id World's identifier.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityPlace
     * @see WorldRepository
     * @throws FOTGAPIException
     */
    public Page<Map<String, Object>> pageWorldPlaces(String id, Pageable pageable) throws FOTGAPIException {
        return PagingConverter.listToPage(worldRepository.findByIdentifier(id).orElseThrow((() ->
            new FOTGAPIException(ServerStatus.LIST_PLACE_NOT_FOUND)
        )).listPlaces(), pageable)
            .map(EntityPlace::toMap);
    }
}

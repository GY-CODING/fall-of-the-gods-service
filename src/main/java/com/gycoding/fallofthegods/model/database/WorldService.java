package com.gycoding.fallofthegods.model.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gycoding.fallofthegods.model.entities.worlds.EntityPlace;
import com.gycoding.fallofthegods.model.entities.worlds.EntityWorld;

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
     */
    public EntityWorld getWorld(String id) {
        return worldRepository.findByIdentifier(id).orElse(null);
    }

    /**
     * Lists all the worlds.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityWorld
     * @see WorldRepository
     */
    public List<EntityWorld> listWorlds() {
        return worldRepository.findAll();
    }

    /**
     * Finds a specific Place in a specific World, both identified by their own identifier.
     * @param id
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityPlace
     * @see WorldRepository
     */
    public EntityPlace getWorldPlace(String idWorld, String idPlace) {
        return worldRepository.findByIdentifier(idWorld).orElse(null).getPlace(idPlace);
    }

    /**
     * Lists all the places in an specific world (specified by its identifier).
     * @param id World's identifier.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityPlace
     * @see WorldRepository
     */
    public List<EntityPlace> listWorldPlaces(String id) {
        return worldRepository.findByIdentifier(id).orElse(null).listPlaces();
    }
}

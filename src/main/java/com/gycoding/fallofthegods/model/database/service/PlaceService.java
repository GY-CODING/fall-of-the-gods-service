package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.PlaceRepository;
import com.gycoding.fallofthegods.model.entities.worlds.EntityPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for the Place entity.
 * @see EntityPlace
 * @see PlaceRepository
 * @see Service
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Service
public class PlaceService {
    @Autowired
    private final PlaceRepository placeRepository = null;

    /**
     * Finds a Place by its identifier.
     * @param id
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityPlace
     * @see PlaceRepository
     */
    public EntityPlace getPlace(String id) {
        return placeRepository.findByIdentifier(id).orElse(null);
    }

    /**
     * Lists all places.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityPlace
     * @see PlaceRepository
     */
    public List<EntityPlace> listPlaces() {
        return placeRepository.findAll();
    }
}

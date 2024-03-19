package com.gycoding.fallofthegods.model.database;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gycoding.fallofthegods.model.entities.worlds.EntityPlace;

/**
 * Service for the Place entity.
 * @see EntityPlace
 * @see PlaceRepository
 * @see Service
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

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

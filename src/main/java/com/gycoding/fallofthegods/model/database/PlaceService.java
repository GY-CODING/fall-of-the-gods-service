package com.gycoding.fallofthegods.model.database;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gycoding.fallofthegods.model.entities.worlds.EntityPlace;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public EntityPlace getPlace(String id) {
        return placeRepository.findByIdentifier(id).orElse(null);
    }

    public List<EntityPlace> listPlaces() {
        return placeRepository.findAll();
    }
}

package com.gycoding.fallofthegods.model.database;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gycoding.fallofthegods.model.entities.Worlds.EntityPlace;
import com.gycoding.fallofthegods.model.entities.Worlds.EntityWorld;

@Service
public class WorldService {
    private final WorldRepository worldRepository;

    public WorldService(WorldRepository worldRepository) {
        this.worldRepository = worldRepository;
    }

    public EntityWorld getWorld(String id) {
        return worldRepository.findByIdentifier(id).orElse(null);
    }

    public List<EntityWorld> listWorlds() {
        return worldRepository.findAll();
    }

    public EntityPlace getWorldPlace(String idWorld, String idPlace) {
        return worldRepository.findByIdentifier(idWorld).orElse(null).getPlace(idPlace);
    }

    public List<EntityPlace> listWorldPlaces(String id) {
        return worldRepository.findByIdentifier(id).orElse(null).listPlaces();
    }
}

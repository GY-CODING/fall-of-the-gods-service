package com.gycoding.fallofthegods.model.database;

import com.gycoding.fallofthegods.model.entities.EntityPlace;
import com.gycoding.fallofthegods.model.entities.EntityWorld;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WorldService {
    private final WorldRepository worldRepository;

    public WorldService(WorldRepository worldRepository) {
        this.worldRepository = worldRepository;
    }

    @SuppressWarnings("null")
    public void insertCharacter(EntityWorld character) {
        worldRepository.save(character);
    }

    public EntityWorld getWorld(int id) {
        EntityWorld world = worldRepository.findAll().get(id);
        world.setID(id);
        return world;
    }

    public EntityPlace getWorldPlace(int idWorld, int idPlace) {
        EntityPlace place = worldRepository.findAll().get(idWorld).getPlace(idPlace);
        place.setID(idPlace);
        return place;
    }

    public List<EntityWorld> listWorlds() {
        return worldRepository.findAll();
    }
}

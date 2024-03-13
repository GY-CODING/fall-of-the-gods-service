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

    @SuppressWarnings("null")
    public void insertCharacter(EntityWorld character) {
        worldRepository.save(character);
    }

    public EntityWorld getWorld(String id) {
        return worldRepository.findByIdentifier(id).orElse(null);
    }

    public EntityPlace getWorldPlace(int idWorld, int idPlace) {
        return worldRepository.findAll().get(idWorld).getPlace(idPlace);
    }

    public List<EntityWorld> listWorlds() {
        return worldRepository.findAll();
    }
}

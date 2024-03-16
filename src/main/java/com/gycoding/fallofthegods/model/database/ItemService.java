package com.gycoding.fallofthegods.model.database;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gycoding.fallofthegods.model.entities.items.EntityItem;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository worldRepository) {
        this.itemRepository = worldRepository;
    }

    public EntityItem getStoryItem(String id) {
        return itemRepository.findByIdentifier(id).orElse(null);
    }

    public List<EntityItem> listStoryItems() {
        return itemRepository.findAll();
    }

    public EntityItem getGameItem(String id) {
        return itemRepository.findByIdentifierAndInGame(id, true).orElse(null);
    }

    public List<EntityItem> listGameItems() {
        return itemRepository.findByInGame(true).orElse(null);
    }
}

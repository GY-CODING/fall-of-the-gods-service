package com.gycoding.fallofthegods.model.database;

import com.gycoding.fallofthegods.model.entities.EntityItem;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository worldRepository) {
        this.itemRepository = worldRepository;
    }

    @SuppressWarnings("null")
    public void insertCharacter(EntityItem character) {
        itemRepository.save(character);
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

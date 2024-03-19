package com.gycoding.fallofthegods.model.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gycoding.fallofthegods.model.entities.items.EntityItem;

/**
 * Service for the Item entity.
 * @see EntityItem
 * @see ItemRepository
 * @see Service
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Service
public class ItemService {
    @Autowired
    private final ItemRepository itemRepository = null;

    /**
     * Finds an Item from the story by its identifier.
     * @param id
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityItem
     * @see ItemRepository
     */
    public EntityItem getStoryItem(String id) {
        return itemRepository.findByIdentifier(id).orElse(null);
    }

    /**
     * Lists all items from the story.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityItem
     * @see ItemRepository
     */
    public List<EntityItem> listStoryItems() {
        return itemRepository.findAll();
    }

    /**
     * Finds an Item from the game by its identifier.
     * @param id
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityItem
     * @see ItemRepository
     */
    public EntityItem getGameItem(String id) {
        return itemRepository.findByIdentifierAndInGame(id, true).orElse(null);
    }

    /**
     * Lists all items from the game.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityItem
     * @see ItemRepository
     */
    public List<EntityItem> listGameItems() {
        return itemRepository.findByInGame(true).orElse(null);
    }
}

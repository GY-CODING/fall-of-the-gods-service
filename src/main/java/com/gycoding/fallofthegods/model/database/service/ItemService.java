package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.ItemRepository;
import com.gycoding.fallofthegods.model.entities.items.EntityItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
     * @return EntityItem
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityItem
     * @see ItemRepository
     */
    public EntityItem getStoryItem(String id) {
        return itemRepository.findByIdentifier(id).orElse(null);
    }

    /**
     * Lists all items from the story.
     * @return List of EntityItem
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityItem
     * @see ItemRepository
     */
    public List<EntityItem> listStoryItems() {
        return itemRepository.findAll();
    }

    /**
     * Lists all items from the story with pagination.
     * @return List of EntityItem
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Map
     * @see Pageable
     * @see Page
     * @see EntityItem
     * @see ItemRepository
     */
    public Page<Map<String, Object>> pageStoryItems(Pageable pageable) {
        return itemRepository.findAll(pageable)
                .map(EntityItem::toMap);
    }

    /**
     * Finds an Item from the game by its identifier.
     * @param id
     * @return EntityItem
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityItem
     * @see ItemRepository
     */
    public EntityItem getGameItem(String id) {
        return itemRepository.findByIdentifierAndInGame(id, true).orElse(null);
    }

    /**
     * Lists all items from the game.
     * @return List of EntityItem
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityItem
     * @see ItemRepository
     */
    public List<EntityItem> listGameItems() {
        return itemRepository.findByInGame(true);
    }

    /**
     * Lists all items from the game with pagination.
     * @return List of EntityItem
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Map
     * @see Pageable
     * @see Page
     * @see EntityItem
     * @see ItemRepository
     */
    public Page<Map<String, Object>> pageGameItems(Pageable pageable) {
        return itemRepository.findByInGame(true, pageable)
                .map(EntityItem::toMap);
    }
}

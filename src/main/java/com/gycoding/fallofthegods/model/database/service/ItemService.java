package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.ItemRepository;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIException;
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
     * @throws FOTGAPIException
     */
    public EntityItem getStoryItem(String id) throws FOTGAPIException {
        return itemRepository.findByIdentifier(id).orElseThrow(() ->
                new FOTGAPIException(ServerStatus.ITEM_NOT_FOUND)
        );
    }

    /**
     * Lists all items from the story.
     * @return List of EntityItem
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityItem
     * @see ItemRepository
     * @throws FOTGAPIException
     */
    public List<EntityItem> listStoryItems() throws FOTGAPIException {
        try {
            return itemRepository.findAll();
        } catch (NullPointerException e) {
            throw new FOTGAPIException(ServerStatus.LIST_ITEM_NOT_FOUND);
        }
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
     * @throws FOTGAPIException
     */
    public Page<Map<String, Object>> pageStoryItems(Pageable pageable) throws FOTGAPIException {
        try {
            return itemRepository.findAll(pageable)
                    .map(EntityItem::toMap);
        } catch (NullPointerException e) {
            throw new FOTGAPIException(ServerStatus.LIST_ITEM_NOT_FOUND);
        }
    }

    /**
     * Finds an Item from the game by its identifier.
     * @param id
     * @return EntityItem
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityItem
     * @see ItemRepository
     * @throws FOTGAPIException
     */
    public EntityItem getGameItem(String id) throws FOTGAPIException {
        return itemRepository.findByIdentifierAndInGame(id, true).orElseThrow(() ->
                new FOTGAPIException(ServerStatus.ITEM_NOT_FOUND)
        );
    }

    /**
     * Lists all items from the game.
     * @return List of EntityItem
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityItem
     * @see ItemRepository
     * @throws FOTGAPIException
     */
    public List<EntityItem> listGameItems() throws FOTGAPIException {
        return itemRepository.findByInGame(true).orElseThrow(() ->
                new FOTGAPIException(ServerStatus.LIST_ITEM_NOT_FOUND)
        );
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
     * @throws FOTGAPIException
     */
    public Page<Map<String, Object>> pageGameItems(Pageable pageable) throws FOTGAPIException {
        final var items = itemRepository.findByInGame(true, pageable).orElseThrow(() ->
                new FOTGAPIException(ServerStatus.LIST_ITEM_NOT_FOUND)
        );

        return items.map(EntityItem::toMap);
    }
}

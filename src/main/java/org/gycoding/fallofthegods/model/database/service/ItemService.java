package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.fallofthegods.model.database.repository.ItemRepository;
import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.model.entities.items.EntityItem;
import org.gycoding.springexceptions.model.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemService {
    @Autowired
    private final ItemRepository itemRepository = null;

    public EntityItem getStoryItem(String id) throws APIException {
        return itemRepository.findByIdentifier(id).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.ITEM_NOT_FOUND.code,
                        FOTGAPIError.ITEM_NOT_FOUND.message,
                        FOTGAPIError.ITEM_NOT_FOUND.status
                )
        );
    }

    public List<EntityItem> listStoryItems() throws APIException {
        try {
            return itemRepository.findAll();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_ITEM_NOT_FOUND.code,
                    FOTGAPIError.LIST_ITEM_NOT_FOUND.message,
                    FOTGAPIError.LIST_ITEM_NOT_FOUND.status
            );
        }
    }

    public Page<Map<String, Object>> pageStoryItems(Pageable pageable) throws APIException {
        try {
            return itemRepository.findAll(pageable)
                    .map(EntityItem::toMap);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_ITEM_NOT_FOUND.code,
                    FOTGAPIError.LIST_ITEM_NOT_FOUND.message,
                    FOTGAPIError.LIST_ITEM_NOT_FOUND.status
            );
        }
    }

    public EntityItem getGameItem(String id) throws APIException {
        return itemRepository.findByIdentifierAndInGame(id, true).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.ITEM_NOT_FOUND.code,
                        FOTGAPIError.ITEM_NOT_FOUND.message,
                        FOTGAPIError.ITEM_NOT_FOUND.status
                )
        );
    }

    public List<EntityItem> listGameItems() throws APIException {
        return itemRepository.findByInGame(true).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.LIST_ITEM_NOT_FOUND.code,
                        FOTGAPIError.LIST_ITEM_NOT_FOUND.message,
                        FOTGAPIError.LIST_ITEM_NOT_FOUND.status
                )
        );
    }

    public Page<Map<String, Object>> pageGameItems(Pageable pageable) throws APIException {
        final var items = itemRepository.findByInGame(true, pageable).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.LIST_ITEM_NOT_FOUND.code,
                        FOTGAPIError.LIST_ITEM_NOT_FOUND.message,
                        FOTGAPIError.LIST_ITEM_NOT_FOUND.status
                )
        );

        return items.map(EntityItem::toMap);
    }
}

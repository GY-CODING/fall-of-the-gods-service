package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.fallofthegods.model.database.repository.ItemRepository;
import org.gycoding.fallofthegods.model.dto.items.ItemRSDTO;
import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.model.entities.items.EntityItem;
import org.gycoding.exceptions.model.APIException;
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

    public ItemRSDTO getStoryItem(String id, String language) throws APIException {
        final var itemEntity = itemRepository.findByIdentifier(id).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.ITEM_NOT_FOUND.code,
                        FOTGAPIError.ITEM_NOT_FOUND.message,
                        FOTGAPIError.ITEM_NOT_FOUND.status
                )
        );

        return ItemRSDTO.builder()
                .identifier(itemEntity.identifier())
                .name(itemEntity.name().get(language))
                .description(itemEntity.description().get(language))
                .image(itemEntity.image())
                .inGame(itemEntity.inGame())
                .stats(itemEntity.stats())
                .type(itemEntity.type())
                .fragments(!itemEntity.fragments().isEmpty() ? itemEntity.fragments().stream().map(item -> ItemRSDTO.builder()
                        .identifier(itemEntity.identifier())
                        .name(itemEntity.name().get(language))
                        .description(itemEntity.description().get(language))
                        .image(itemEntity.image())
                        .inGame(itemEntity.inGame())
                        .stats(itemEntity.stats())
                        .type(itemEntity.type())
                        .fragments(List.of())
                        .build()
                ).toList() : List.of())
                .build();
    }

    public List<ItemRSDTO> listStoryItems(String language) throws APIException {
        try {
            final var itemEntities = itemRepository.findAll();

            return itemEntities.stream().map(itemEntity -> ItemRSDTO.builder()
                    .identifier(itemEntity.identifier())
                    .name(itemEntity.name().get(language))
                    .description(itemEntity.description().get(language))
                    .image(itemEntity.image())
                    .inGame(itemEntity.inGame())
                    .stats(itemEntity.stats())
                    .type(itemEntity.type())
                    .fragments(!itemEntity.fragments().isEmpty() ? itemEntity.fragments().stream().map(item -> ItemRSDTO.builder()
                            .identifier(itemEntity.identifier())
                            .name(itemEntity.name().get(language))
                            .description(itemEntity.description().get(language))
                            .image(itemEntity.image())
                            .inGame(itemEntity.inGame())
                            .stats(itemEntity.stats())
                            .type(itemEntity.type())
                            .fragments(List.of())
                            .build()
                    ).toList() : List.of())
                    .build()
            ).toList();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_ITEM_NOT_FOUND.code,
                    FOTGAPIError.LIST_ITEM_NOT_FOUND.message,
                    FOTGAPIError.LIST_ITEM_NOT_FOUND.status
            );
        }
    }

    public Page<Map<String, Object>> pageStoryItems(Pageable pageable, String language) throws APIException {
        try {
            final var itemEntities = itemRepository.findAll(pageable);

            return itemEntities.map(itemEntity -> ItemRSDTO.builder()
                    .identifier(itemEntity.identifier())
                    .name(itemEntity.name().get(language))
                    .description(itemEntity.description().get(language))
                    .image(itemEntity.image())
                    .inGame(itemEntity.inGame())
                    .stats(itemEntity.stats())
                    .type(itemEntity.type())
                    .fragments(!itemEntity.fragments().isEmpty() ? itemEntity.fragments().stream().map(item -> ItemRSDTO.builder()
                            .identifier(itemEntity.identifier())
                            .name(itemEntity.name().get(language))
                            .description(itemEntity.description().get(language))
                            .image(itemEntity.image())
                            .inGame(itemEntity.inGame())
                            .stats(itemEntity.stats())
                            .type(itemEntity.type())
                            .fragments(List.of())
                            .build()
                    ).toList() : List.of())
                    .build().toMap()
            );
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_ITEM_NOT_FOUND.code,
                    FOTGAPIError.LIST_ITEM_NOT_FOUND.message,
                    FOTGAPIError.LIST_ITEM_NOT_FOUND.status
            );
        }
    }

    public ItemRSDTO getGameItem(String id, String language) throws APIException {
        final var itemEntity = itemRepository.findByIdentifierAndInGame(id, true).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.ITEM_NOT_FOUND.code,
                        FOTGAPIError.ITEM_NOT_FOUND.message,
                        FOTGAPIError.ITEM_NOT_FOUND.status
                )
        );

        return ItemRSDTO.builder()
                .identifier(itemEntity.identifier())
                .name(itemEntity.name().get(language))
                .description(itemEntity.description().get(language))
                .image(itemEntity.image())
                .inGame(itemEntity.inGame())
                .stats(itemEntity.stats())
                .type(itemEntity.type())
                .fragments(!itemEntity.fragments().isEmpty() ? itemEntity.fragments().stream().map(item -> ItemRSDTO.builder()
                        .identifier(itemEntity.identifier())
                        .name(itemEntity.name().get(language))
                        .description(itemEntity.description().get(language))
                        .image(itemEntity.image())
                        .inGame(itemEntity.inGame())
                        .stats(itemEntity.stats())
                        .type(itemEntity.type())
                        .fragments(List.of())
                        .build()
                ).toList() : List.of())
                .build();
    }

    public List<ItemRSDTO> listGameItems(String language) throws APIException {
        final var itemEntities = itemRepository.findByInGame(true).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.LIST_ITEM_NOT_FOUND.code,
                        FOTGAPIError.LIST_ITEM_NOT_FOUND.message,
                        FOTGAPIError.LIST_ITEM_NOT_FOUND.status
                )
        );

        return itemEntities.stream().map(itemEntity -> ItemRSDTO.builder()
                .identifier(itemEntity.identifier())
                .name(itemEntity.name().get(language))
                .description(itemEntity.description().get(language))
                .image(itemEntity.image())
                .inGame(itemEntity.inGame())
                .stats(itemEntity.stats())
                .type(itemEntity.type())
                .fragments(!itemEntity.fragments().isEmpty() ? itemEntity.fragments().stream().map(item -> ItemRSDTO.builder()
                        .identifier(itemEntity.identifier())
                        .name(itemEntity.name().get(language))
                        .description(itemEntity.description().get(language))
                        .image(itemEntity.image())
                        .inGame(itemEntity.inGame())
                        .stats(itemEntity.stats())
                        .type(itemEntity.type())
                        .fragments(List.of())
                        .build()
                ).toList() : List.of())
                .build()
        ).toList();
    }

    public Page<Map<String, Object>> pageGameItems(Pageable pageable, String language) throws APIException {
        final var itemEntities = itemRepository.findByInGame(true, pageable).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.LIST_ITEM_NOT_FOUND.code,
                        FOTGAPIError.LIST_ITEM_NOT_FOUND.message,
                        FOTGAPIError.LIST_ITEM_NOT_FOUND.status
                )
        );

        return itemEntities.map(itemEntity -> ItemRSDTO.builder()
                .identifier(itemEntity.identifier())
                .name(itemEntity.name().get(language))
                .description(itemEntity.description().get(language))
                .image(itemEntity.image())
                .inGame(itemEntity.inGame())
                .stats(itemEntity.stats())
                .type(itemEntity.type())
                .fragments(!itemEntity.fragments().isEmpty() ? itemEntity.fragments().stream().map(item -> ItemRSDTO.builder()
                        .identifier(itemEntity.identifier())
                        .name(itemEntity.name().get(language))
                        .description(itemEntity.description().get(language))
                        .image(itemEntity.image())
                        .inGame(itemEntity.inGame())
                        .stats(itemEntity.stats())
                        .type(itemEntity.type())
                        .fragments(List.of())
                        .build()
                ).toList() : List.of())
                .build().toMap()
        );
    }
}

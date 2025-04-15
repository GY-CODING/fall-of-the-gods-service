package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.items.ItemMO;
import org.gycoding.fallofthegods.domain.repository.ItemRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.ItemDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.model.items.ItemEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.ItemMongoRepository;
import org.gycoding.fallofthegods.shared.PagingConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {
    private final ItemMongoRepository repository;

    private final ItemDatabaseMapper mapper;

    @Override
    public ItemMO save(ItemMO item) throws APIException {
        try {
            return mapper.toMO(repository.save(mapper.toEntity(item)));
        } catch (Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }
    }

    @Override
    public Optional<ItemMO> get(String identifier) throws APIException {
        final var itemEntity = repository.findByIdentifier(identifier).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return Optional.of(mapper.toMO(itemEntity));
    }

    public Optional<ItemMO> get(String identifier, Boolean inGame) throws APIException {
        Optional<ItemEntity> itemEntity;

        if (inGame) {
            itemEntity = repository.findByIdentifierAndInGame(identifier, inGame);
        } else {
            itemEntity = repository.findByIdentifier(identifier);
        }

        itemEntity.orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return Optional.of(mapper.toMO(itemEntity.get()));
    }

    public List<ItemMO> list() throws APIException {
        List<ItemEntity> itemEntities;

        try {
            itemEntities = repository.findAll();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return itemEntities.stream().map(mapper::toMO).toList();
    }

    public List<ItemMO> list(Boolean inGame) throws APIException {
        List<ItemEntity> itemEntities;

        try {
            if (inGame) {
                itemEntities = repository.findByInGame(inGame);
            } else {
                itemEntities = repository.findAll();
            }
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return itemEntities.stream().map(mapper::toMO).toList();
    }

    public Page<ItemMO> page(Pageable pageable) throws APIException {
        Page<ItemEntity> itemEntities;

        try {
            itemEntities = repository.findAll(pageable);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return PagingConverter.listToPage(itemEntities.stream().map(mapper::toMO).toList(), pageable);
    }

    public Page<ItemMO> page(Pageable pageable, Boolean inGame) throws APIException {
        Page<ItemEntity> itemEntities;

        try {
            if (inGame) {
                itemEntities = repository.findByInGame(inGame, pageable);
            } else {
                itemEntities = repository.findAll(pageable);
            }
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return PagingConverter.listToPage(itemEntities.stream().map(mapper::toMO).toList(), pageable);
    }

    @Override
    public void delete(String identifier) throws APIException {
        try {
            repository.removeByIdentifier(identifier);
        } catch (Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }
    }
}
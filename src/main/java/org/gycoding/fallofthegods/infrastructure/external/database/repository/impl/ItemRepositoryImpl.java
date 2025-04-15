package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
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
    public ItemMO save(ItemMO item) {
        return mapper.toMO(repository.save(mapper.toEntity(item)));
    }

    @Override
    public void delete(String identifier) {
        repository.removeByIdentifier(identifier);
    }

    @Override
    public Optional<ItemMO> get(String identifier) {
        return repository.findByIdentifier(identifier)
                .map(mapper::toMO);
    }

    @Override
    public Optional<ItemMO> get(String identifier, Boolean inGame) {
        Optional<ItemEntity> itemEntity;

        if(inGame) {
            itemEntity = repository.findByIdentifierAndInGame(identifier, inGame);
        } else {
            itemEntity = repository.findByIdentifier(identifier);
        }

        return itemEntity.map(mapper::toMO);
    }

    @Override
    public List<ItemMO> list() {
        return repository.findAll().stream()
                .map(mapper::toMO)
                .toList();
    }

    @Override
    public List<ItemMO> list(Boolean inGame) {
        List<ItemEntity> itemEntities;

        if(inGame) {
            itemEntities = repository.findByInGame(inGame);
        } else {
            itemEntities = repository.findAll();
        }

        return itemEntities.stream()
                .map(mapper::toMO)
                .toList();
    }

    @Override
    public Page<ItemMO> page(Pageable pageable) {
        return PagingConverter.listToPage(
                repository.findAll(pageable).stream()
                        .map(mapper::toMO)
                        .toList(),
                pageable
        );
    }

    @Override
    public Page<ItemMO> page(Pageable pageable, Boolean inGame) {
        Page<ItemEntity> itemEntities;

        if(inGame) {
            itemEntities = repository.findByInGame(inGame, pageable);
        } else {
            itemEntities = repository.findAll(pageable);
        }

        return PagingConverter.listToPage(
                itemEntities.stream()
                        .map(mapper::toMO)
                        .toList(),
                pageable
        );
    }
}
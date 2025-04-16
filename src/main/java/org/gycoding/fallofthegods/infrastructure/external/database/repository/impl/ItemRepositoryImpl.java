package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.items.ItemMO;
import org.gycoding.fallofthegods.domain.repository.ItemRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.ItemDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.ItemMongoRepository;
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
    public ItemMO update(ItemMO item) throws APIException {
        final var persistedItem = repository.findByIdentifier(item.identifier()).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return mapper.toMO(repository.save(mapper.toUpdatedEntity(persistedItem, item)));
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
    public List<ItemMO> list() {
        return repository.findAll().stream()
                .map(mapper::toMO)
                .toList();
    }

    @Override
    public Page<ItemMO> page(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toMO);
    }
}
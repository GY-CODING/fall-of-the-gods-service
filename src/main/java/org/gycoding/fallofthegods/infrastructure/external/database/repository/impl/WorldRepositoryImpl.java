package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.fallofthegods.domain.model.worlds.WorldMO;
import org.gycoding.fallofthegods.domain.repository.WorldRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.WorldDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.PlaceMongoRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.WorldMongoRepository;
import org.gycoding.fallofthegods.shared.PagingConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WorldRepositoryImpl implements WorldRepository {
    private final WorldMongoRepository repository;

    private final WorldDatabaseMapper mapper;

    private final PlaceMongoRepository placeRepository;

    @Override
    public WorldMO save(WorldMO world, List<String> places) {
        final var persistedPlaces = places.stream()
                        .map(placeRepository::findByIdentifier)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .toList();

        return mapper.toMO(repository.save(mapper.toEntity(world, persistedPlaces)));
    }

    @Override
    public void delete(String identifier) {
        repository.removeByIdentifier(identifier);
    }

    @Override
    public Optional<WorldMO> get(String identifier) {
        return repository.findByIdentifier(identifier)
                .map(mapper::toMO);
    }

    @Override
    public List<WorldMO> list() {
        return repository.findAll().stream()
                .map(mapper::toMO)
                .toList();
    }

    @Override
    public Page<WorldMO> page(Pageable pageable) {
        return PagingConverter.listToPage(
                repository.findAll(pageable).stream()
                        .map(mapper::toMO)
                        .toList(),
                pageable
        );
    }
}
package org.gycoding.heraldsofchaos.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.domain.exceptions.FOTGAPIError;
import org.gycoding.heraldsofchaos.domain.model.worlds.WorldMO;
import org.gycoding.heraldsofchaos.domain.repository.WorldRepository;
import org.gycoding.heraldsofchaos.infrastructure.external.database.mapper.WorldDatabaseMapper;
import org.gycoding.heraldsofchaos.infrastructure.external.database.repository.PlaceMongoRepository;
import org.gycoding.heraldsofchaos.infrastructure.external.database.repository.WorldMongoRepository;
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
    public WorldMO update(WorldMO world, List<String> places) throws APIException {
        final var persistedWorlds = repository.findByIdentifier(world.identifier()).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        final var persistedPlaces = places.stream()
                .map(placeRepository::findByIdentifier)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        return mapper.toMO(repository.save(mapper.toUpdatedEntity(persistedWorlds, world, persistedPlaces)));
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
        return repository.findAll(pageable)
                .map(mapper::toMO);
    }
}
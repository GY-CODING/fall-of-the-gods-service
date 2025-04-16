package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.worlds.PlaceMO;
import org.gycoding.fallofthegods.domain.repository.PlaceRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.PlaceDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.PlaceMongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaceRepositoryImpl implements PlaceRepository {
    private final PlaceMongoRepository repository;

    private final PlaceDatabaseMapper mapper;

    @Override
    public PlaceMO save(PlaceMO place) {
        return mapper.toMO(repository.save(mapper.toEntity(place)));
    }

    @Override
    public PlaceMO update(PlaceMO place) throws APIException {
        final var persistedPlace = repository.findByIdentifier(place.identifier()).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                ));

        return mapper.toMO(repository.save(mapper.toUpdatedEntity(persistedPlace, place)));
    }

    @Override
    public void delete(String identifier) {
        repository.removeByIdentifier(identifier);
    }

    @Override
    public Optional<PlaceMO> get(String identifier) {
        return repository.findByIdentifier(identifier)
                .map(mapper::toMO);
    }

    @Override
    public List<PlaceMO> list() {
        return repository.findAll().stream()
                .map(mapper::toMO)
                .toList();
    }

    @Override
    public Page<PlaceMO> page(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toMO);
    }
}
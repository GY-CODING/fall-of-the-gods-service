package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.worlds.PlaceMO;
import org.gycoding.fallofthegods.domain.repository.PlaceRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.PlaceDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.model.worlds.PlaceEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.PlaceMongoRepository;
import org.gycoding.fallofthegods.shared.PagingConverter;
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
    public PlaceMO save(PlaceMO place) throws APIException {
        try {
            return mapper.toMO(repository.save(mapper.toEntity(place)));
        } catch (Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }
    }

    @Override
    public Optional<PlaceMO> get(String identifier) throws APIException {
        final var placeEntity = repository.findByIdentifier(identifier).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return Optional.of(mapper.toMO(placeEntity));
    }

    public Optional<PlaceMO> get(String identifier, Boolean inGame) throws APIException {
        Optional<PlaceEntity> placeEntity;

        if (inGame) {
            placeEntity = repository.findByIdentifierAndInGame(identifier, inGame);
        } else {
            placeEntity = repository.findByIdentifier(identifier);
        }

        placeEntity.orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return Optional.of(mapper.toMO(placeEntity.get()));
    }

    public List<PlaceMO> list() throws APIException {
        List<PlaceEntity> placeEntities;

        try {
            placeEntities = repository.findAll();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return placeEntities.stream().map(mapper::toMO).toList();
    }

    public List<PlaceMO> list(Boolean inGame) throws APIException {
        List<PlaceEntity> placeEntities;

        try {
            if (inGame) {
                placeEntities = repository.findByInGame(inGame);
            } else {
                placeEntities = repository.findAll();
            }
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return placeEntities.stream().map(mapper::toMO).toList();
    }

    public Page<PlaceMO> page(Pageable pageable) throws APIException {
        Page<PlaceEntity> placeEntities;

        try {
            placeEntities = repository.findAll(pageable);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return PagingConverter.listToPage(placeEntities.stream().map(mapper::toMO).toList(), pageable);
    }

    public Page<PlaceMO> page(Pageable pageable, Boolean inGame) throws APIException {
        Page<PlaceEntity> placeEntities;

        try {
            if (inGame) {
                placeEntities = repository.findByInGame(inGame, pageable);
            } else {
                placeEntities = repository.findAll(pageable);
            }
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return PagingConverter.listToPage(placeEntities.stream().map(mapper::toMO).toList(), pageable);
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
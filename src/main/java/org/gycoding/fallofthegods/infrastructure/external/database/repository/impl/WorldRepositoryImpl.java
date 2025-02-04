package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.worlds.WorldMO;
import org.gycoding.fallofthegods.domain.repository.WorldRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.WorldDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.model.worlds.WorldEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.WorldMongoRepository;
import org.gycoding.fallofthegods.shared.util.PagingConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Override
    public WorldMO save(WorldMO world) throws APIException {
        try {
            return mapper.toMO(repository.save(mapper.toEntity(world)));
        } catch (Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }
    }

    @Override
    public Optional<WorldMO> get(String identifier) throws APIException {
        final var worldEntity = repository.findByIdentifier(identifier).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return Optional.of(mapper.toMO(worldEntity));
    }

    public List<WorldMO> list() throws APIException {
        List<WorldEntity> worldEntities;

        try {
            worldEntities = repository.findAll();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return worldEntities.stream().map(mapper::toMO).toList();
    }

    public Page<WorldMO> page(Pageable pageable) throws APIException {
        Page<WorldEntity> worldEntities;

        try {
            worldEntities = repository.findAll(pageable);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return PagingConverter.listToPage(worldEntities.stream().map(mapper::toMO).toList(), pageable);
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
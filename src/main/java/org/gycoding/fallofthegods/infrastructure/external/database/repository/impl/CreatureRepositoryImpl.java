package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.creatures.CreatureMO;
import org.gycoding.fallofthegods.domain.repository.CreatureRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.CreatureDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.model.creatures.CreatureEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.CreatureMongoRepository;
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
public class CreatureRepositoryImpl implements CreatureRepository {
    private final CreatureMongoRepository repository;

    private final CreatureDatabaseMapper mapper;

    @Override
    public CreatureMO save(CreatureMO creature) throws APIException {
        try {
            return mapper.toMO(repository.save(mapper.toEntity(creature)));
        } catch (Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }
    }

    @Override
    public Optional<CreatureMO> get(String identifier) throws APIException {
        final var creatureEntity = repository.findByIdentifier(identifier).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return Optional.of(mapper.toMO(creatureEntity));
    }

    public Optional<CreatureMO> get(String identifier, Boolean inGame) throws APIException {
        Optional<CreatureEntity> creatureEntity;

        if (inGame) {
            creatureEntity = repository.findByIdentifierAndInGame(identifier, inGame);
        } else {
            creatureEntity = repository.findByIdentifier(identifier);
        }

        creatureEntity.orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return Optional.of(mapper.toMO(creatureEntity.get()));
    }

    public List<CreatureMO> list() throws APIException {
        List<CreatureEntity> creatureEntities;

        try {
            creatureEntities = repository.findAll();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return creatureEntities.stream().map(mapper::toMO).toList();
    }

    public List<CreatureMO> list(Boolean inGame) throws APIException {
        List<CreatureEntity> creatureEntities;

        try {
            if (inGame) {
                creatureEntities = repository.findByInGame(inGame);
            } else {
                creatureEntities = repository.findAll();
            }
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return creatureEntities.stream().map(mapper::toMO).toList();
    }

    public Page<CreatureMO> page(Pageable pageable) throws APIException {
        Page<CreatureEntity> creatureEntities;

        try {
            creatureEntities = repository.findAll(pageable);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return PagingConverter.listToPage(creatureEntities.stream().map(mapper::toMO).toList(), pageable);
    }

    public Page<CreatureMO> page(Pageable pageable, Boolean inGame) throws APIException {
        Page<CreatureEntity> creatureEntities;

        try {
            if (inGame) {
                creatureEntities = repository.findByInGame(inGame, pageable);
            } else {
                creatureEntities = repository.findAll(pageable);
            }
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return PagingConverter.listToPage(creatureEntities.stream().map(mapper::toMO).toList(), pageable);
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
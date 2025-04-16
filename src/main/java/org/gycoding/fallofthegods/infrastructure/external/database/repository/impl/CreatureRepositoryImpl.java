package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.creatures.CreatureMO;
import org.gycoding.fallofthegods.domain.repository.CreatureRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.CreatureDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.CreatureMongoRepository;
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
    public CreatureMO save(CreatureMO creature) {
        return mapper.toMO(repository.save(mapper.toEntity(creature)));
    }

    @Override
    public CreatureMO update(CreatureMO creature) throws APIException {
        final var persistedCreature = repository.findByIdentifier(creature.identifier()).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return mapper.toMO(repository.save(mapper.toUpdatedEntity(persistedCreature, creature)));
    }

    @Override
    public void delete(String identifier) {
        repository.removeByIdentifier(identifier);
    }

    @Override
    public Optional<CreatureMO> get(String identifier) {
        return repository.findByIdentifier(identifier)
                .map(mapper::toMO);
    }

    @Override
    public List<CreatureMO> list() {
        return repository.findAll().stream()
                .map(mapper::toMO)
                .toList();
    }

    @Override
    public Page<CreatureMO> page(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toMO);
    }
}
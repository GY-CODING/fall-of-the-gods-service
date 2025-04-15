package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.fallofthegods.domain.model.creatures.CreatureMO;
import org.gycoding.fallofthegods.domain.repository.CreatureRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.CreatureDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.model.creatures.CreatureEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.CreatureMongoRepository;
import org.gycoding.fallofthegods.shared.PagingConverter;
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
    public void delete(String identifier) {
        repository.removeByIdentifier(identifier);
    }

    @Override
    public Optional<CreatureMO> get(String identifier) {
        return repository.findByIdentifier(identifier)
                .map(mapper::toMO);
    }

    @Override
    public Optional<CreatureMO> get(String identifier, Boolean inGame) {
        Optional<CreatureEntity> creatureEntity;

        if(inGame) {
            creatureEntity = repository.findByIdentifierAndInGame(identifier, inGame);
        } else {
            creatureEntity = repository.findByIdentifier(identifier);
        }

        return creatureEntity.map(mapper::toMO);
    }

    @Override
    public List<CreatureMO> list() {
        return repository.findAll().stream()
                .map(mapper::toMO)
                .toList();
    }

    @Override
    public List<CreatureMO> list(Boolean inGame) {
        List<CreatureEntity> creatureEntities;

        if(inGame) {
            creatureEntities = repository.findByInGame(inGame);
        } else {
            creatureEntities = repository.findAll();
        }

        return creatureEntities.stream()
                .map(mapper::toMO)
                .toList();
    }

    @Override
    public Page<CreatureMO> page(Pageable pageable) {
        return PagingConverter.listToPage(
                repository.findAll(pageable).stream()
                        .map(mapper::toMO)
                        .toList(),
                pageable
        );
    }

    @Override
    public Page<CreatureMO> page(Pageable pageable, Boolean inGame) {
        Page<CreatureEntity> creatureEntities;

        if(inGame) {
            creatureEntities = repository.findByInGame(inGame, pageable);
        } else {
            creatureEntities = repository.findAll(pageable);
        }

        return PagingConverter.listToPage(
                creatureEntities.stream()
                        .map(mapper::toMO)
                        .toList(),
                pageable
        );
    }
}
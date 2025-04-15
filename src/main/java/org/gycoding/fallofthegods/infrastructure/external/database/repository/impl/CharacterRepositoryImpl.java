package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.characters.CharacterMO;
import org.gycoding.fallofthegods.domain.repository.CharacterRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.CharacterDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.model.characters.CharacterEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.CharacterMongoRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.WorldMongoRepository;
import org.gycoding.fallofthegods.shared.PagingConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CharacterRepositoryImpl implements CharacterRepository {
    private final CharacterMongoRepository repository;

    private final CharacterDatabaseMapper mapper;

    private final WorldMongoRepository worldRepository;

    @Override
    public CharacterMO save(CharacterMO character) throws APIException {
        final var persistedWorld = worldRepository.findByIdentifier(character.world()).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return mapper.toMO(repository.save(mapper.toEntity(character, persistedWorld)));
    }

    @Override
    public void delete(String identifier) {
        repository.removeByIdentifier(identifier);
    }

    @Override
    public Optional<CharacterMO> get(String identifier) {
        return repository.findByIdentifier(identifier)
                .map(mapper::toMO);
    }

    @Override
    public Optional<CharacterMO> get(String identifier, Boolean inGame) {
        Optional<CharacterEntity> characterEntity;

        if(inGame) {
            characterEntity = repository.findByIdentifierAndInGame(identifier, inGame);
        } else {
            characterEntity = repository.findByIdentifier(identifier);
        }

        return characterEntity.map(mapper::toMO);
    }

    @Override
    public List<CharacterMO> list() {
        return repository.findAll().stream()
                .map(mapper::toMO)
                .toList();
    }

    @Override
    public List<CharacterMO> list(Boolean inGame) {
        List<CharacterEntity> characterEntities;

        if(inGame) {
            characterEntities = repository.findByInGame(inGame);
        } else {
            characterEntities = repository.findAll();
        }

        return characterEntities.stream()
                .map(mapper::toMO)
                .toList();
    }

    @Override
    public Page<CharacterMO> page(Pageable pageable) {
        return PagingConverter.listToPage(
                repository.findAll(pageable).stream()
                    .map(mapper::toMO)
                    .toList(),
                pageable
        );
    }

    @Override
    public Page<CharacterMO> page(Pageable pageable, Boolean inGame) {
        Page<CharacterEntity> characterEntities;

        if(inGame) {
            characterEntities = repository.findByInGame(inGame, pageable);
        } else {
            characterEntities = repository.findAll(pageable);
        }

        return PagingConverter.listToPage(
                characterEntities.stream()
                        .map(mapper::toMO)
                        .toList(),
                pageable
        );
    }
}

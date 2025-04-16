package org.gycoding.heraldsofchaos.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.domain.exceptions.FOTGAPIError;
import org.gycoding.heraldsofchaos.domain.model.characters.CharacterMO;
import org.gycoding.heraldsofchaos.domain.repository.CharacterRepository;
import org.gycoding.heraldsofchaos.infrastructure.external.database.mapper.CharacterDatabaseMapper;
import org.gycoding.heraldsofchaos.infrastructure.external.database.repository.CharacterMongoRepository;
import org.gycoding.heraldsofchaos.infrastructure.external.database.repository.WorldMongoRepository;
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
    public CharacterMO update(CharacterMO character) throws APIException {
        final var persistedCharacter = repository.findByIdentifier(character.identifier()).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        final var persistedWorld = worldRepository.findByIdentifier(character.world()).orElse(null);

        return mapper.toMO(repository.save(mapper.toUpdatedEntity(persistedCharacter, character, persistedWorld)));
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
    public List<CharacterMO> list() {
        return repository.findAll().stream()
                .map(mapper::toMO)
                .toList();
    }

    @Override
    public Page<CharacterMO> page(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toMO);
    }
}
